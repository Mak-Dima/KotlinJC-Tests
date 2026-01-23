package com.example.kotlinjc_tests.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.kotlinjc_tests.services.MockHttpService
import com.example.kotlinjc_tests.utils.ViewState
import com.example.kotlinjc_tests.utils.mockData
import com.example.kotlinjc_tests.viewModels.DataListViewModel
import kotlinx.serialization.json.Json

@Composable
fun DataList(
    padding: PaddingValues,
    viewModel: DataListViewModel
) {
    when (viewModel.state) {
        ViewState.LOADING -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }
        ViewState.READY -> {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 10.dp)
                    .testTag("data_list")
            ) {
                items (viewModel.data ?: emptyList()) { data ->
                    DataRow(data)
                }
            }
        }
        ViewState.ERROR -> {
            ErrorAlert("Error Message")
        }
    }
}

@PreviewScreenSizes
@Composable
fun DataListPreview() {
    val padding = PaddingValues(vertical = 25.dp)
    val data = Json.encodeToString(mockData)
    val service = MockHttpService(data)
    val viewModel = DataListViewModel(service)
    DataList(padding = padding, viewModel = viewModel)
}
