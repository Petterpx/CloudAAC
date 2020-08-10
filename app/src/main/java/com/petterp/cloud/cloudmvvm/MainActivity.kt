package com.petterp.cloud.cloudmvvm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBing.setOnClickListener {
            startActivity(Intent(this, TestDataBingActivity::class.java))
        }
        btnVm.setOnClickListener {
            startActivity(Intent(this, TestVmActivity::class.java))
        }

        btnTab.setOnClickListener {
            startActivity(Intent(this, TestTabActivity::class.java))
        }
    }

}