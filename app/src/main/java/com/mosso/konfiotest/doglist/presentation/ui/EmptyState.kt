package com.mosso.konfiotest.doglist.presentation.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.airbnb.lottie.compose.LottieCompositionSpec
import com.mosso.konfiotest.R
import com.mosso.konfiotest.doglist.presentation.theme.ui.KonfioTestTheme


@Composable
fun EmptyState(
    modifier: Modifier = Modifier
) {
    Box(Modifier.fillMaxSize()) {
        InfiniteAnimation(
            spec = LottieCompositionSpec.Asset("box_empty.json"),
            contentScale = ContentScale.Fit,
            modifier = modifier
                .width(200.dp)
                .height(200.dp)
                .align(Alignment.Center),
            isCompleted = true,
        )

        Text(
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(32.dp),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.title_empty_state),
        )
    }
}

@Composable
@Preview
fun EmptyStatePreview() {
    KonfioTestTheme {
        EmptyState()
    }
}

