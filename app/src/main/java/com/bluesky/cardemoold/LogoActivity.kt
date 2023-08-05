package com.bluesky.cardemoold

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bluesky.cardemoold.adapter.LogoAdapter
import com.bluesky.cardemoold.bean.Brand
import com.bluesky.cardemoold.bean.BrandListResult
import com.bluesky.cardemoold.databinding.ActivityLogoBinding
import com.bluesky.cardemoold.utils.CarApi
import com.bluesky.cardemoold.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogoActivity : AppCompatActivity() {

    private val Tag: String = this.javaClass.name
    val binding: ActivityLogoBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_logo)
    }

    var mData = mutableListOf<Brand>()
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

/*        binding.rvList.addOnItemTouchListener(object: RecyclerView.OnItemTouchListener{
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                TODO("Not yet implemented")
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                rv.get
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                TODO("Not yet implemented")
            }

        })*/
    }

    private fun loadDatas(letter: String) {
        val api = RetrofitUtils.getApi(CarApi.baseUrl, CarApi::class.java)
        api.getBrandList(CarApi.key, letter).enqueue(object : Callback<BrandListResult> {
            override fun onResponse(
                call: Call<BrandListResult>,
                response: Response<BrandListResult>
            ) {
                val result: BrandListResult? = response.body()
                mAdapter.setData(result?.result)
                //Log.d(Tag, response.message())
                //Log.d(Tag, response.raw().toString())
                //Log.d(Tag, response.body().toString())
            }

            override fun onFailure(call: Call<BrandListResult>, t: Throwable) {
                Log.d(Tag, t.message.toString())
            }

        })

    }
}

