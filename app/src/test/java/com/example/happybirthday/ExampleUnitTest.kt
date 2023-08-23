package com.example.happybirthday

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun generates_numberS() {
        val dice = Dice(100)
        val rollResult = dice.roll()
        assertTrue("The values generated was not between 1 and 100", rollResult in 1..100)
    }
}