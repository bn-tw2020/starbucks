package com.example.todo.starbucks.screen.common

import android.util.Log
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.example.todo.starbucks.R
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("textFormatRecommendMenu")
fun textFormat(view: TextView, title: String) {
    view.text = HtmlCompat.fromHtml(view.context.getString(R.string.label_recommend_menu, title),
        HtmlCompat.FROM_HTML_MODE_LEGACY)
}


@BindingAdapter("setTimeFormat")
fun timeFormat(view: TextView, time: String) {
    val date = Date(time.toLong())
    val AMPM = SimpleDateFormat("a", Locale("ko", "KR")).format(date)
    val calendar = Calendar.getInstance()
    calendar.time = date
    calendar.get(Calendar.DAY_OF_WEEK)

    var isWeekend = false
    when (calendar.get(Calendar.DAY_OF_WEEK)) {
        1 -> isWeekend = true
        2 -> isWeekend = false
        3 -> isWeekend = false
        4 -> isWeekend = false
        5 -> isWeekend = false
        6 -> isWeekend = false
        7 -> isWeekend = true
    }

    val week = if (isWeekend) "주말" else "주중"
    val hour = calendar.get(Calendar.HOUR)
    view.text = "$week $AMPM ${hour}시 기준"
}