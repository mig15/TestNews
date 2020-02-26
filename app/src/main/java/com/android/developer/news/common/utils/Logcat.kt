package com.android.developer.news.common.utils

import android.util.Log

fun logcat(msg: String, tag: String = "---My Log---") {
    Log.d(tag, msg)
}