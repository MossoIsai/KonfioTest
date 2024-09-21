package com.mosso.konfiotest.doglist.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.RenderMode
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun InfiniteAnimation(
    spec: LottieCompositionSpec,
    modifier: Modifier = Modifier,
    contentScale: ContentScale,
    isCompleted: Boolean
) {
    val composition by rememberLottieComposition(spec)
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = if (isCompleted) 1 else LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        renderMode = RenderMode.SOFTWARE,
        modifier = modifier,
        contentScale = contentScale
    )
}

@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier
) {

    Box(
        Modifier
            .fillMaxSize()
            .padding(200.dp),
        contentAlignment = Alignment.Center
    ) {
        InfiniteAnimation(
            isCompleted = false,
            spec = LottieCompositionSpec.Asset("dog_animation.json"),
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}

