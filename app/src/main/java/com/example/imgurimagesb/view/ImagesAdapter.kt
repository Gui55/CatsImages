package com.example.imgurimagesb.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.imgurimagesb.data.model.ImageModel
import com.example.imgurimagesb.util.imageloader.ImageLoader

class ImagesAdapter(
    val imageLoader: ImageLoader
) : ListAdapter<ImageModel, ImagesViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        return ImagesViewHolder.create(parent, imageLoader)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        getItem(position)?.let{
            holder.bind(it)
        }
    }

    companion object{
        private val diffCallback = object : DiffUtil.ItemCallback<ImageModel>(){
            override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
                return oldItem.link == newItem.link
            }

            override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
                return oldItem == newItem
            }
        }
    }

}