package com.bluesky.cardemoold

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import com.bluesky.cardemoold.adapter.LogoAdapter
import com.bluesky.cardemoold.bean.BrandListResult
import com.bluesky.cardemoold.databinding.ActivityLogoBinding
import com.bluesky.cardemoold.utils.CarApi
import com.bluesky.cardemoold.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogoActivity : AppCompatActivity() {

    val binding: ActivityLogoBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_logo)
    }

    var mData = mutableListOf<com.bluesky.cardemoold.bean.Brand>()
    val mAdapter: LogoAdapter by lazy {
        LogoAdapter(this, mData)
    }
    var letterMsg = "当前品牌首字母:"
    var letter = "A"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      setContentView(R.layout.activity_logo)
        binding.adapter = mAdapter
        binding.name = letterMsg + letter
        loadDatas(letter)
        binding.btnSearch.setOnClickListener {
            val lt = binding.etSearch.text.toString().trim().uppercase()
            if (!TextUtils.isEmpty(lt) && !lt.equals(letter)) {
                letter = lt
                binding.name = letterMsg + letter
                loadDatas(letter)
            }
        }
    }

    private fun loadDatas(letter: String) {
        val api = RetrofitUtils.getApi(CarApi.baseUrl, CarApi::class.java)
        val call = api.getBrandList(CarApi.key, letter).enqueue(object : Callback<BrandListResult> {
            override fun onResponse(
                call: Call<BrandListResult>,
                response: Response<BrandListResult>
            ) {
                val result: BrandListResult? = response.body()
                mAdapter.setData(result?.brand)
            }

            override fun onFailure(call: Call<BrandListResult>, t: Throwable) {
                
            }

        })

    }
}

