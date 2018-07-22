package com.taoszu.androidpaging.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.amitshekhar.DebugDB
import com.taoszu.androidpaging.R
import kotlinx.android.synthetic.main.act_main.*

/**
 * Created by 阿涛 on 2018/7/15.
 */
class MainActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        btn_db_data.setOnClickListener {
            startActivity(Intent(this, DbDataPagingActivity::class.java))
        }

        btn_local_data.setOnClickListener {
            startActivity(Intent(this, LocalDataPagingActivity::class.java))
        }

    }
}