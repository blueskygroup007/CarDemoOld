package com.bluesky.cardemoold

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bluesky.cardemoold.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //DataBinding:3
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //DataBinding:4
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnNews.setOnClickListener(this)
        binding.btnBrand.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnNews -> {
                startActivity(Intent(this,LogoActivity::class.java))
            }
            binding.btnBrand -> {}

            else -> {}
        }
    }
}