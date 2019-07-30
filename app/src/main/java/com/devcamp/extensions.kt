package com.devcamp

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.load(url: String?, placeholder: Drawable?) =
    placeholder?.apply {
        Picasso.with(context)
            .load(if (url?.isNotEmpty() == true) url else null)
            .placeholder(placeholder)
            .error(placeholder)
            .into(this@load)
    }
