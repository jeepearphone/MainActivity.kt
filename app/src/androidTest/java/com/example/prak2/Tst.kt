package com.example.prak2

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)

class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun plusStakanN() {
        composeTestRule.setContent {
            WaterTracker()
        }
        composeTestRule.onNodeWithTag("countWater").assertExists()
        composeTestRule.onNodeWithTag("plus").run {
           assertExists()
           performClick()
        }
           composeTestRule.onNodeWithTag("countWater").assertTextContains("250 мл")


    }

    @Test
    fun endDayN() {
        composeTestRule.setContent {
            WaterTracker()
        }

        composeTestRule.onNodeWithTag("countDay").assertExists()
        composeTestRule.onNodeWithTag("plus").assertExists()
        composeTestRule.onNodeWithTag("endDay").assertExists()


        repeat(5){
            composeTestRule.onNodeWithTag("plus").performClick()
        }
        composeTestRule.onNodeWithTag("endDay").performClick()
        composeTestRule.onNodeWithText("Количество дней подряд, в которые было выпито более 1500 мл - 0").assertExists()

        repeat(6) {
            composeTestRule.onNodeWithTag("plus").performClick()
        }
        composeTestRule.onNodeWithTag("endDay").performClick()
        composeTestRule.onNodeWithText("Количество дней подряд, в которые было выпито более 1500 мл - 1").assertExists()
        repeat(6) {
            composeTestRule.onNodeWithTag("plus").performClick()
        }
        composeTestRule.onNodeWithTag("endDay").performClick()
        composeTestRule.onNodeWithText("Количество дней подряд, в которые было выпито более 1500 мл - 2").assertExists()

        composeTestRule.onNodeWithTag("endDay").performClick()
        composeTestRule.onNodeWithText("Количество дней подряд, в которые было выпито более 1500 мл - 0").assertExists()


    }

}