package com.mosso.konfiotest.doglist.presentation.ui

import com.mosso.konfiotest.doglist.domain.model.Dog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mosso.konfiotest.R
import com.mosso.konfiotest.doglist.presentation.theme.ui.KonfioTestTheme

@Composable
fun DogComponent(
    dog: Dog
) {
    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .wrapContentHeight()
            .padding(start = 10.dp, end = 10.dp, bottom = 16.dp, top = 16.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomStart = 16.dp,
                    bottomEnd = 16.dp
                )
            )
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 80.dp)
                .height(150.dp)
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.padding(
                    start = 40.dp,
                    top = 15.dp,
                    end = 15.dp,
                    bottom = 15.dp
                )
            ) {
                Text(
                    text = dog.name, fontSize = 18.sp,
                    color = colorResource(id = R.color.black)
                )
                Text(
                    text = dog.description,
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.gray),
                    lineHeight = 14.sp
                )
                Text(
                    text = dog.age.toString(), fontSize = 12.sp,
                    color = colorResource(id = R.color.black)
                )
            }
        }
        AsyncImage(
            placeholder = painterResource(R.drawable.ic_launcher_background),
            modifier = Modifier
                .size(width = 110.dp, height = 180.dp)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                ),
            contentDescription = dog.name,
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalContext.current)
                .data(dog.imageUrl)
                .crossfade(true)
                .build(),
        )
    }
}

@Composable
@Preview
fun DogComponentPreview() {
    KonfioTestTheme {
        val dog = Dog(
            name = "Pastor Belga",
            "White with blacks spots, he is a bodyguard",
            8,
            ""
        )
        DogComponent(dog = dog)
    }
}