package com.mosso.konfiotest.doglist.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.mosso.konfiotest.R
import com.mosso.konfiotest.doglist.presentation.state.DogListUIState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogListScreen(
    lazyListState: LazyListState,
    uiState: DogListUIState
) {
    val context = LocalContext.current
    LaunchedEffect(uiState) {
        if (uiState is DogListUIState.Error) {
            Toast.makeText(context, uiState.exception, Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = colorResource(id = R.color.gray_low),
                    titleContentColor = colorResource(id = R.color.black),
                ),
                title = {
                    Text(stringResource(id = R.string.title))
                }
            )
        },
    ) { innerPadding ->
        when (uiState) {
            is DogListUIState.Error -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    EmptyState(modifier = Modifier.fillMaxSize())
                }
            }

            DogListUIState.Loading -> {
                LoadingAnimation(Modifier.fillMaxSize())
            }

            is DogListUIState.Success -> {
                val dogList = uiState.dogList ?: arrayListOf()
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .background(colorResource(id = R.color.gray_low)),
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