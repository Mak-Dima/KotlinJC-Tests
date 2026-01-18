package com.example.kotlinjc_tests.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DataList(padding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .padding(padding)
            .padding(horizontal = 10.dp)
            .testTag("data_list")
    ) {
        items(100) { index ->
            Row(
                modifier = Modifier
                    .padding(vertical = 3.dp)
                    .fillMaxSize()
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.primary,
                        shape = MaterialTheme.shapes.medium
                    )
            ) {
                Text(
                    text = "Item $index",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun DataListPreview() {
    val padding = PaddingValues(vertical = 25.dp)
    DataList(padding = padding)
}