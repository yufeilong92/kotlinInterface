package com.example.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

/**
 * @Author : YFL  is Creating a porject in MyApplication
 * @Package com.example.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2019/6/19 17:33
 * @Purpose :
 */
class RlvAdapter(var mContext: Context, var data: MutableList<String>) :
    RecyclerView.Adapter<RlvAdapter.ItemViewHolde>() {


    private var mInflater: LayoutInflater? = null

    init {
        mInflater = LayoutInflater.from(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemViewHolde {
        val view = mInflater!!.inflate(R.layout.item, null)
        val holder = ItemViewHolde(view)
        return holder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolde, position: Int) {
        holder.mTv.text = data[position]

        holder.mTv.setOnClickListener {
            onUpdataListener?.invoke(2, data[position])
            setDataLisener?.invoke()
            val invoke = getData?.invoke(position, data[position])
            Log.e("222",""+invoke)
        }

    }

    class ItemViewHolde(val item: View) : RecyclerView.ViewHolder(item) {
        val mTv = item.findViewById<TextView>(R.id.tv_content)

    }

    private var onUpdataListener: ((index: Int, str: String) -> Unit)? = null

    fun setOnUpDateListener(onUpdateListener: ((index: Int, str: String) -> Unit)) {
        this.onUpdataListener = onUpdateListener
    }

    private var setDataLisener: (() -> Unit)? = null
    fun setDateListener(list: (() -> Unit)) {
        this.setDataLisener = list
    }

    private var getData: ((index: Int, str: String) -> Int)? = null

    fun getDataContent(mlist: (index: Int, str: String) -> Int) {
        this.getData = mlist
    }

}