package com.example.myapplication.mvp.presenter

import android.content.Context
import com.example.myapplication.mvp.contract.AContrat

/**
 * @Author : YFL  is Creating a porject in MyApplication
 * @Package com.example.myapplication.mvp.presenter
 * @Email : yufeilong92@163.com
 * @Time :2019/6/26 11:20
 * @Purpose :
 */
class AContrat : AContrat.Presenter {
    var view: AContrat.View? = null
    var model: AContrat.Model? = null
    override fun initMvp(view: AContrat.View, model: AContrat.Model) {
        this.view = view
        this.model = model
    }

    override fun requestCarLength(context: Context) {
        model?.requestCarLength(context, onSuccess = {
            view!!.Success(it)
        }, onError = {
            view!!.Error(Throwable())
        })
    }
}