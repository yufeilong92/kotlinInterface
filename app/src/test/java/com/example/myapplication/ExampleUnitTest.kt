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
        val pserson = data.initAlso()
    }
    @Test
    fun randam1(){
        val randam=Random
        val nextInt = randam.nextInt( 2)
        println(nextInt)
        randam1()
    }
}
