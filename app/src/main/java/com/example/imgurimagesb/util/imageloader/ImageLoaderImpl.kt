package com.example.imgurimagesb.util.imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class ImageLoaderImpl @Inject constructor() : ImageLoader {
    override fun load(imageView: ImageView, imageUrl: String) {
        Glide.with(imageView.rootView)
            .load(imageUrl)
            .into(imageView)
    }
}