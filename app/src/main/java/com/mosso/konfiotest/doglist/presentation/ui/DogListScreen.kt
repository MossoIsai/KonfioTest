package com.mosso.konfiotest.doglist.presentation.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.mosso.konfiotest.doglist.presentation.state.DogListUIState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogListScreen(
    lazyListState: LazyListState,
    uiState: DogListUIState
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Dogs We Love", textAlign = TextAlign.Center)
                }
            )
        },
    ) { innerPadding ->
        when (uiState) {
            is DogListUIState.Error -> {
                Log.d("BEBE", "error: "+uiState.throwable)
                Toast.makeText(LocalContext.current, uiState.throwable.message, Toast.LENGTH_SHORT)
                    .show()
            }

            DogListUIState.EmptyState -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                }
            }

            DogListUIState.Loading -> {

            }

            is DogListUIState.Success -> {
                val dogList = uiState.dogList ?: arrayListOf()
                LazyColumn(
                    modifier = Modifier.padding(innerPadding),
                    state = lazyListState
                ) {
                    items(dogList) { item ->
                        DogComponent(dog = item)
                    }
                }
            }
        }
    }
}