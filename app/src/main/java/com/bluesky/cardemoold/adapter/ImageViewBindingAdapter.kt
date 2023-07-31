package com.bluesky.cardemoold.adapter

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bluesky.cardemoold.R
import com.squareup.picasso.Picasso
import retrofit2.http.Url

/**
 *
 * @author BlueSky
 * @date 23.7.29
 * Description:
 */
object ImageViewBindingAdapter {

    //BindingAdapter 2:
    // 需要在model的build.gradle中的plugin{}中添加
    @BindingAdapter("itemImage")
    @JvmStatic
    fun setImage(image: ImageView, url: String) {
        if (TextUtils.isEmpty(url)) {
            image.setImageResource(R.mipmap.ic_launcher_round)
        } else {
            Picasso.get()
                .load(url)
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .into(image)
        }
    }
}