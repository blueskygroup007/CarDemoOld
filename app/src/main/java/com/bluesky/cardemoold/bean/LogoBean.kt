package com.bluesky.cardemoold.bean

/**
 *
 * @author BlueSky
 * @date 23.7.28
 * Description:
 */
data class LogoBean(
    val error_code: Int,
    val reason: String,
    val result: List<Result>
) : java.io.Serializable

data class Result(
    val brand_logo: String,
    val brand_name: String,
    val first_letter: String,
    val id: String
) : java.io.Serializable