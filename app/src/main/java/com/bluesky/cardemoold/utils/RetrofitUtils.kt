package com.bluesky.cardemoold.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * @author BlueSky
 * @date 2023/7/31
 * Description:
 */
object RetrofitUtils {
    private var retrofit: Retrofit? = null

    fun getRetrofit(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun <T> getApi(baseUrl: String, cls: Class<T>): T {
        return getRetrofit(baseUrl).create(cls)
    }

}