package com.example.imgurimagesb.util.imageloader

import android.widget.ImageView

interface ImageLoader {

    fun load(
        imageView: ImageView,
        imageUrl: String
    )

}