package com.mosso.konfiotest.doglist.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mosso.konfiotest.doglist.domain.model.Dog
import com.mosso.konfiotest.doglist.presentation.state.DogListUIState
import com.mosso.konfiotest.doglist.presentation.theme.ui.KonfioTestTheme
import com.mosso.konfiotest.doglist.presentation.viewmodel.DogListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KonfioTestTheme {
                val state = viewModel.dogListUIState.collectAsStateWithLifecycle().value
                val lazyListState = rememberLazyListState()
                DogListScreen(lazyListState = lazyListState, uiState = state)
            }
        }
    }
}