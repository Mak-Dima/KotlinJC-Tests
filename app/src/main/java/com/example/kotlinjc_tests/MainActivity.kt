package com.example.kotlinjc_tests

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kotlinjc_tests.ui.theme.KotlinJCTestsTheme
import com.example.kotlinjc_tests.views.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinJCTestsTheme {
                MainScreen()
            }
        }
    }
}
