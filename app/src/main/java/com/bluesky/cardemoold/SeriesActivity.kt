package com.bluesky.cardemoold

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bluesky.cardemoold.adapter.SeriesListAdapter
import com.bluesky.cardemoold.bean.Series
import com.bluesky.cardemoold.bean.SeriesListResult
import com.bluesky.cardemoold.databinding.ActivitySeriesBinding
import com.bluesky.cardemoold.utils.CarApi
import com.bluesky.cardemoold.utils.CarApi.Companion.baseUrl
import com.bluesky.cardemoold.utils.CarApi.Companion.key
import com.bluesky.cardemoold.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeriesActivity : AppCompatActivity() {

    private val TAG: String = this.javaClass.name
    val binding: ActivitySeriesBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_series)
    }
    //lateinit var data: MutableList<Series>

    val adapter = SeriesListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val brandid = intent.getStringExtra("brandid")
        val api = RetrofitUtils.getApi(baseUrl, CarApi::class.java)
        val layoutManager = LinearLayoutManager(this@SeriesActivity)

        binding.rvListSeries.layoutManager = layoutManager
        binding.rvListSeries.adapter = adapter
        brandid?.let {

            val call = api.getSeriesList(key, brandid)

            call.enqueue(object : Callback<SeriesListResult> {
                override fun onResponse(
                    call: Call<SeriesListResult>,
                    response: Response<SeriesListResult>
                ) {
                    response.body()?.let {
                        val seriesListResult: SeriesListResult = response.body()!!
                        val seriesList: List<Series> = seriesListResult.result
                        val data: MutableList<Series> = seriesList.toMutableList()
                        adapter.setData(data)
                    }
                }

                override fun onFailure(call: Call<SeriesListResult>, t: Throwable) {
                    Log.d(TAG, "获取系列数据失败!")
                }

            })
        }

    }

}