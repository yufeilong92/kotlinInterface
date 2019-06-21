# kotlinInterface
 ### 注：适用于回调接口单个方法
 ##   1.方法无参无返回值回调
  ### (1)声明回调接口，以及初始化接口
  ```
      private var setDataLisener: (() -> Unit)? = null
      fun setDateListener(list: (() -> Unit)) {
          this.setDataLisener = list
      }
      //(2)接口方法的调用
     setDataLisener?.invoke()
     //外部调用接口
      adapter.setDateListener {
                 Toast.makeText(this@MainActivity,"请求失败",Toast.LENGTH_SHORT).show()
             }
  ```
  ## 2.方法有参无返回值回调
  ```
  //(1)声明回调接口，以及初始化
   private var onUpdataListener: ((index: Int, str: String) -> Unit)? = null
  
      fun setOnUpDateListener(onUpdateListener: ((index: Int, str: String) -> Unit)) {
          this.onUpdataListener = onUpdateListener
      }
      //(2)接口方法的调用
          onUpdataListener?.invoke(2, data[position])
          
      //(3)外部调用接口
       adapter.setOnUpDateListener { index, str ->
                  Log.e("22","=="+str)
              }
```
## 3.方法有参有返回值回调
```
//1)接口声明，以及初始化
 private var getData: ((index: Int, str: String) -> Int)? = null

    fun getDataContent(mlist: (index: Int, str: String) -> Int) {
        this.getData = mlist
    }
     //(2)接口方法调用
               val invoke = getData?.invoke(position, data[position])
      //(3)外部调用接口         
  adapter.getDataContent { index, str ->
            Log.e("22",str+"")
            index
        }
```
```
  //run即可作用于Any，又可作为this代码块，run返回执行的是处理结果
    fun initData(str: String?) {
        str?.run {
            var con = this.replace("2", "3")
            println(con)
        }
    }

    // apply用法类似run，区别在于apply执行完成block()函数后，返回自身对象
// 返回自身对象，可以使用链式方法使用.apply{}.apply{}
    fun initPserson(str: String?): String? {
        return str?.apply {
            var con = this.replace("3", "你")

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
    fun initWith(str: String?):String?{
        //写法一,对象receiver和一个lambda函数块
        return  with(str,{
            "222"
        })
        //由于with函数最后一个参数是一个函数，可以把函数提到圆括号的外部修改后
        return with(str){
            "222"
        }
    }

```