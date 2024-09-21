package com.mosso.konfiotest.doglist.presentation.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.airbnb.lottie.compose.LottieCompositionSpec
import com.mosso.konfiotest.R
import com.mosso.konfiotest.doglist.presentation.theme.ui.KonfioTestTheme


@Composable
fun EmptyState(
    modifier: Modifier = Modifier
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(200.dp),
        contentAlignment = Alignment.Center
    ) {
        InfiniteAnimation(
            spec = LottieCompositionSpec.Asset("box_empty.json"),
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
        Text(text = stringResource(id = R.string.title_empty_state))
    }
}

@Composable
@Preview
fun EmptyStatePreview() {
   KonfioTestTheme {
       EmptyState()
   }
}

