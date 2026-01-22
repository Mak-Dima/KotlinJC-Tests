package com.example.kotlinjc_tests.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp

@Composable
fun ErrorAlert(message: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.5f))
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .sizeIn(maxWidth = 250.dp, maxHeight = 250.dp)
                .background(Color.White, RoundedCornerShape(10))
                .border(1.dp, Color.Black, RoundedCornerShape(10))
                .padding(24.dp)
        ) {
            Text(
                text = message,
                textAlign = TextAlign.Center,
                maxLines = 12
            )
        }
    }
}


@PreviewScreenSizes
@Composable
fun ErrorViewPreview() {
    ErrorAlert("This is a longer error message that will wrap inside the constrained box.")
}
