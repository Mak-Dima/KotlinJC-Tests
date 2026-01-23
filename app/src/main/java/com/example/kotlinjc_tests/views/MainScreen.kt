package com.example.kotlinjc_tests.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinjc_tests.services.HttpService
import com.example.kotlinjc_tests.viewModels.DataListViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    var isLoaded by remember { mutableStateOf(false) }
    val service = HttpService()
    val vm = DataListViewModel(service)
    val scope = rememberCoroutineScope()


    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        if (isLoaded) {
            DataList(innerPadding, vm)
        } else {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                FilledIconButton(
                    onClick = {
                        scope.launch {
                            vm.loadData()
                            isLoaded = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("main_screen_button"),
                ) {
                    Text(
                        "Load",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun GreetingPreview() {
    MainScreen()
}