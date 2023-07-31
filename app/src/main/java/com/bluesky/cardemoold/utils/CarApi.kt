package com.bluesky.cardemoold.utils

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.bluesky.cardemoold.bean.Brand
import com.bluesky.cardemoold.bean.BrandListResult
import com.bluesky.cardemoold.bean.ModelsListResult
import com.bluesky.cardemoold.bean.SeriesListResult

/**
 *
 * @author BlueSky
 * @date 2023/8/1
 * Description:
 */
interface CarApi {
    companion object {
        val baseUrl = "http://apis.juhe.cn/cxdq/"
        val key = "未申请"
    }

    @GET("brand")
    fun getBrandList(
        @Query("key") key: String,
        @Query("first_letter") first_letter: String
    ): Call<BrandListResult>

    @GET("series")
    fun getSeriesList(
        @Query("key") key: String,
        @Query("brandid") brandid: String
    ): Call<SeriesListResult>

    @GET("models")
    fun getModelsList(
        @Query("key") key: String,
        @Query("series_id") series_id: String
    ): Call<ModelsListResult>
}