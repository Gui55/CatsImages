package com.example.imgurimagesb.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imgurimagesb.databinding.RecyclerItemBinding
import com.example.imgurimagesb.data.model.ImageModel
import com.example.imgurimagesb.util.imageloader.ImageLoader

class ImagesViewHolder(
    recyclerItemBinding: RecyclerItemBinding,
    val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(recyclerItemBinding.root) {

    private val img = recyclerItemBinding.ivImages

    fun bind(imageModel: ImageModel){
        imageLoader.load(img, imageModel.link)
    }

    companion object{
        fun create(
            parent: ViewGroup,
            imageLoader: ImageLoader
        ) : ImagesViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = RecyclerItemBinding.inflate(inflater, parent, false)
            return ImagesViewHolder(itemBinding, imageLoader)
        }
    }

}