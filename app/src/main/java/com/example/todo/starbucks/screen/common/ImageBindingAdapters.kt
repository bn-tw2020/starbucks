package com.example.todo.starbucks.screen.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.todo.starbucks.GlideApp
import com.example.todo.starbucks.R

@BindingAdapter("setImage")
fun setImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        GlideApp.with(view)
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(view)
    }
}