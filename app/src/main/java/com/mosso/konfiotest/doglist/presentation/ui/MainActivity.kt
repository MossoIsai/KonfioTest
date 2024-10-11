package com.mosso.konfiotest.doglist.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.rememberLazyListState
import com.mosso.konfiotest.doglist.presentation.theme.ui.KonfioTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KonfioTestTheme {
                val lazyListState = rememberLazyListState()
                DogListScreen(lazyListState = lazyListState)
            }
        }
    }
}