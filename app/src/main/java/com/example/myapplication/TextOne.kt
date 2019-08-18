package com.example.myapplication

/**
 * @Author : YFL  is Creating a porject in MyApplication
 * @Package com.example.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2019/6/21 13:59
 * @Purpose :
 */
class TextOne {
    var one = {}
    var two: (index: Int, str: String) -> Unit = { index, str ->

    }
    var three = { index: Int, str: String, postion: Int ->

    }
    var four = {}
    //run即可作用于Any，又可作为this代码块，run返回执行的是处理结果
    fun initData(str: String?) {
        str?.run {
            this.replace("2", "3")
        }
    }

    // apply用法类似run，区别在于apply执行完成block()函数后，返回自身对象
// 返回自身对象，可以使用链式方法使用.apply{}.apply{}
    fun initPserson(str: String?): String? {
        return str?.apply {
            var con = this.replace("3", "你")
            println(con)
            println(this)
        }
    }

    // apply用法类似run，区别在于apply执行完成block()函数后，返回自身对象
// 返回自身对象，可以使用链式方法使用.apply{}.apply{}
    fun initListData(list: MutableList<String>?): MutableList<String>? {
        return list?.apply {
            this.add("小明")
            this.add("小红")
            this.add("小李")
            this.add("小米")
            this.add("小死")
        }
    }

    //let内部使用it指代当前对象，返回最后一行处理结果， (T) -> R
    fun initOpen(str: String?): Any? {
        return str?.let {
            it.plus("22")
            it.drop(2)
        }
    }

    //with函数作用于一个对象，返回最后一行处理结果
    fun initWith(str: String?): String? {
        //写法一,对象receiver和一个lambda函数块
        return with(str, {
            "222"
        })
        //由于with函数最后一个参数是一个函数，可以把函数提到圆括号的外部修改后
        return with(str) {
            "222"
        }
    }

    //与let函数相似，区别是also执行完成后返回对象本身,let返回处理结果
    fun initAlso() {
        var mlist = mutableListOf<String>()
        for (index in 0..20) {
            mlist.add("测试" + index)
        }
        mlist.also {
            for (item in mlist) {
                println(item)
            }
        }
    }


}