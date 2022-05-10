package com.example.todo.starbucks.screen.common

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.todo.starbucks.R

@BindingAdapter("textFormatRecommendMenu")
fun textFormat(view: TextView, title: String) {
    view.text = view.context.getString(R.string.label_recommend_menu, title)
}