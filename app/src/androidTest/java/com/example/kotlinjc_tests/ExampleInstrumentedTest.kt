package com.example.kotlinjc_tests

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.kotlinjc_tests.ui.theme.KotlinJCTestsTheme
import com.example.kotlinjc_tests.views.MainScreen
import org.junit.Test
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
                MainScreen()
            }
        }

        val mainButton = composeTestRule.onNodeWithTag("main_screen_button")
        val dataList = composeTestRule.onNodeWithTag("data_list")

        mainButton.assertExists()
        mainButton.performClick()

        dataList.assertExists()
        val nodes = dataList.onChildren().fetchSemanticsNodes()
        assert(nodes.isNotEmpty())
    }
}