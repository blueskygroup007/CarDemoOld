package com.bluesky.cardemoold.bean

/**
 *
 * @author BlueSky
 * @date 23.7.28
 * Description:
 */
data class BrandListResult(
    val error_code: Int,
    val reason: String,
    var result: List<Brand>
)

data class Brand(
    val brand_logo: String,
    val brand_name: String,
    val first_letter: String,
    val id: String
) : java.io.Serializable

data class SeriesListResult(
    val error_code: Int,
    val reason: String,
    val result: List<Series>
)

data class Series(
    val brandid: String,
    val id: String,
    val levelid: String,
    val levelname: String,
    val name: String,
    val sname: String
):java.io.Serializable

data class ModelsListResult(
    val error_code: Int,
    val reason: String,
    val result: List<Models>
)

data class Models(
    val id: String,
    val name: String,
    val peizhi: String,
    val series_id: String,
    val year: String
)
