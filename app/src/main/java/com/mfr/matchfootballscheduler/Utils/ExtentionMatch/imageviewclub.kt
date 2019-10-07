package com.mfr.matchfootballscheduler.Utils.ExtentionMatch


import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

internal fun ImageView.imageclubload(url: String) {

    Log.e("sttingurl", "mesassageurl" + url)
    if (!url.isEmpty()) {
        Glide.with(this.context).load(url).asBitmap().centerCrop().into(this)
    }
}