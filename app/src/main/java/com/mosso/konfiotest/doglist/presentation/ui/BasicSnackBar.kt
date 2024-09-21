package com.mosso.konfiotest.doglist.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mosso.konfiotest.doglist.presentation.theme.ui.KonfioTestTheme

@Composable
fun BasicSnackBar(modifier: Modifier = Modifier, message: String) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier.height(52.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp, end = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = message, fontSize = 12.sp)
            }
        }
    }
}

@Composable
@Preview
fun BasicSnackBarPreview() {
    KonfioTestTheme {
        val message = "Device is offline. Please check your Internet connection and try again."
        BasicSnackBar(message = message)
    }
}