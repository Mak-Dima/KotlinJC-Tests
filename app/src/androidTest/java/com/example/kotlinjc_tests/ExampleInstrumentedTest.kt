package com.example.kotlinjc_tests

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.kotlinjc_tests.ui.theme.KotlinJCTestsTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TestApplicationBehavior() {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appFlowTest() {
        composeTestRule.setContent {
            KotlinJCTestsTheme {

            }
        }

    }
}