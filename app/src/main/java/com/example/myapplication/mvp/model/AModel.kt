package com.example.myapplication.mvp.model

import android.content.Context
import com.example.myapplication.mvp.contract.AContrat
import kotlin.random.Random

/**
 * @Author : YFL  is Creating a porject in MyApplication
 * @Package com.example.myapplication.mvp.model
 * @Email : yufeilong92@163.com
 * @Time :2019/6/26 11:17
 * @Purpose :
 */
class AModel:AContrat.Model {
    override fun requestCarLength(context: Context, onSuccess: (str:String) -> Unit, onError: (str:String) -> Unit) {
        val random=Random
        val int = random.nextInt(2)
        if (int==0){
            onSuccess("请求成功$int")
        }else{
            onError("请求失败$int")
        }
    }
}