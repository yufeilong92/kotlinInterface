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