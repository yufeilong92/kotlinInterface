package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*
import kotlin.random.Random

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun Text() {
        val data = TextOne()
        data.initData("123456789")
        var content = data.initPserson("123456789")
        println(content)
        var list = data.initListData(mutableListOf())
        for (item in list!!) {
            println(item)
        }
       var con= data.initOpen("测试护士")
        println(con)
        data.initAlso()
    }
    @Test
    fun randam1(){
        val randam=Random
        val nextInt = randam.nextInt( 2)
        println(nextInt)
        randam1()
    }
}
