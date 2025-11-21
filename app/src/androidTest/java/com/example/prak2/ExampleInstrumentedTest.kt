package com.example.prak2

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
//@RunWith(AndroidJUnit4::class)

class MyTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun plusStakan() {
        composeTestRule.setContent {
            WaterTracker()
        }
        composeTestRule.onNodeWithTag("countWater").assertExists()
        composeTestRule.onNodeWithTag("plusStakan").run {
            assertExists()
            performClick()
        }
        composeTestRule.onNodeWithText("250 мл").assertExists()
    }

    @Test
    fun endDay() {
        composeTestRule.setContent {
            WaterTracker()
        }

        composeTestRule.onNodeWithTag("countDay").assertExists()
        composeTestRule.onNodeWithTag("plusStakan").assertExists()
        composeTestRule.onNodeWithTag("endDay").assertExists()


        repeat(5){
            composeTestRule.onNodeWithTag("plusStakan").performClick()
        }
        composeTestRule.onNodeWithTag("endDay").performClick()
        composeTestRule.onNodeWithText("Количество дней подряд, в которые было выпито более 1500 мл - 0").assertExists()

        repeat(6) {
            composeTestRule.onNodeWithTag("plusStakan").performClick()
        }
        composeTestRule.onNodeWithTag("endDay").performClick()
        composeTestRule.onNodeWithText("Количество дней подряд, в которые было выпито более 1500 мл - 1")
        repeat(6) {
            composeTestRule.onNodeWithTag("plusStakan").performClick()
        }
        composeTestRule.onNodeWithTag("endDay").performClick()
        composeTestRule.onNodeWithText("Количество дней подряд, в которые было выпито более 1500 мл - 2")

        composeTestRule.onNodeWithTag("endDay").performClick()
        composeTestRule.onNodeWithText("Количество дней подряд, в которые было выпито более 1500 мл - 0")


    }

}