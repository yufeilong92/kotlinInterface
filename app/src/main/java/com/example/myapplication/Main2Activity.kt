package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.mvp.contract.AContrat
import kotlinx.android.synthetic.main.activity_main2.*
import kotlin.random.Random

class Main2Activity : AppCompatActivity() ,AContrat.View{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initOnClick()
    }

    var index: Int = 1
    fun initOnClick() {

        btn_one.setOnClickListener {
            val randam=Random
            val int = randam.nextInt(2)
            requestListener(int,onSuccesss = {
                Log.e("===", "onsuccess$it")
            },onError = {
                Log.e("===", "onerror$it")
            })
        }
        btn_two.setOnClickListener {
        }
        btn_three.setOnClickListener {

        }
        btn_four.setOnClickListener {

        }
    }

    fun requestListener(index: Int, onSuccesss: (index:Int) -> Unit, onError: (index:Int) -> Unit) {
        //请求网络接口
        if (index  == 0) {
            onSuccesss(index)
        } else {
            onError(index)
        }
    }
    override fun Success(t: Any?) {
    }

    override fun Error(ex: Throwable) {
    }

    override fun Complise() {
    }

}
