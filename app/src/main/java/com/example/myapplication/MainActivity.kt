package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lin = GridLayoutManager(this, 1)
        lin.orientation = GridLayoutManager.VERTICAL
        val adapter = RlvAdapter(this, getData())
        rlv_content.layoutManager = lin
        rlv_content.adapter = adapter
        adapter.setOnUpDateListener { index, str ->
            Log.e("22","=="+str)
            val intent=Intent(this@MainActivity,Main2Activity::class.java)
            startActivity(intent)
        }
        adapter.setDateListener {
            Toast.makeText(this@MainActivity,"请求失败",Toast.LENGTH_SHORT).show()

        }
        adapter.getDataContent { index, str ->
            Log.e("22",str+"")
            index
        }

    }

    private fun getData(): MutableList<String> {
        val data = mutableListOf<String>()
        for (index in 0 until 100) {
            data.add("item=$index")
        }
        return data
    }


}
