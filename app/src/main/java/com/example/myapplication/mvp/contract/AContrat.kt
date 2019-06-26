package com.example.myapplication.mvp.contract

import android.content.Context

/**
 * @Author : YFL  is Creating a porject in MyApplication
 * @Package com.example.myapplication.mvp.contract
 * @Email : yufeilong92@163.com
 * @Time :2019/6/26 11:16
 * @Purpose :
 */
interface AContrat {
    interface View {
        fun Success(t: Any?)
        fun Error(ex: Throwable)
        fun Complise()
    }

    interface Model {
        fun requestCarLength(context: Context,onSuccess:(str:String)->Unit,onError:(str:String)->Unit)
    }

    interface Presenter {
        fun initMvp(view: View, model: Model)
        fun requestCarLength(context: Context)
    }
}