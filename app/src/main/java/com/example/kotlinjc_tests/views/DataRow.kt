package com.example.kotlinjc_tests.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinjc_tests.models.DataObject

@Composable
fun DataRow(data: DataObject) {
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
            text = data.name,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@PreviewScreenSizes
@Composable
fun DataRowPreview() {
    val data = DataObject(id = "1", name = "Test Name")
    DataRow(data)
}