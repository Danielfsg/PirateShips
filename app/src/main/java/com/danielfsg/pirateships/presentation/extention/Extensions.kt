package com.danielfsg.pirateships.presentation.extention

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.danielfsg.pirateships.R

fun ImageView.loadUrlImage(context: Context, url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(R.drawable.ic_baseline_directions_boat_24)
        .error(R.drawable.ic_baseline_directions_boat_24)
        .fallback(R.drawable.ic_baseline_directions_boat_24)
        .into(this)
}