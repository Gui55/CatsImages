package com.example.imgurimagesb.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imgurimagesb.databinding.ActivityMainBinding
import com.example.imgurimagesb.usecase.base.ResultStatus
import com.example.imgurimagesb.util.imageloader.ImageLoader
import com.example.imgurimagesb.viewmodel.ImagesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ImagesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ImagesViewModel by viewModels()

    @Inject
    lateinit var imageLoader: ImageLoader

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initRecyclerView()
        viewModel.fetchImages()
        setupObservations()
    }

    private fun initView(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun initRecyclerView(){
        recyclerView = binding.recyclerImages
        recyclerView.layoutManager = GridLayoutManager(this, 4)
        adapter = ImagesAdapter(imageLoader)
        recyclerView.adapter = adapter
    }

    private fun setupObservations() {
        viewModel.images.observe(this){
            when(it){
                ResultStatus.Loading -> {
                    turnOnList(false)
                }
                is ResultStatus.Success -> {
                    adapter.submitList(it.data)
                    turnOnList(true)
                }
                is ResultStatus.Error -> Toast.makeText(this, it.throwable.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun turnOnList(showList: Boolean){
        if(showList){
            if(binding.tvLoading.visibility != View.GONE){
                binding.tvLoading.visibility = View.GONE
            }

            if(binding.recyclerImages.visibility != View.VISIBLE){
                binding.recyclerImages.visibility = View.VISIBLE
            }
        } else {
            if(binding.tvLoading.visibility != View.VISIBLE){
                binding.tvLoading.visibility = View.VISIBLE
            }

            if(binding.recyclerImages.visibility != View.GONE){
                binding.recyclerImages.visibility = View.GONE
            }
        }
    }
}