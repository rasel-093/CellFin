package com.example.cellfin.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cellfin.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@ExperimentalPagerApi
@Composable
fun Carousel() {
    val carouselImages = listOf(
        R.drawable.s1,
        R.drawable.s2,
        R.drawable.s3,
        R.drawable.s4,
        R.drawable.s5,
        R.drawable.s6,
        R.drawable.s7,
        R.drawable.s8,
        R.drawable.s9,
        R.drawable.s10
    )

    val pageState = rememberPagerState()
    Row(modifier = Modifier.fillMaxWidth(.95f)) {
        Card(
            shape = RoundedCornerShape(16.dp),
        ) {
            HorizontalPager(
                state = pageState,
                count = carouselImages.size
            ) { page ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //
                    Image(
                        painterResource(id = carouselImages[page]),
                        "",
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }


        }
    }
    LaunchedEffect(pageState.currentPage) {
        // wait for 3 seconds.
        delay(3000)
        // increasing the position and check the size
        var newPosition = pageState.currentPage + 1
        if (newPosition > carouselImages.lastIndex) newPosition = 0
        // scrolling to the new position(starting from the beginning).
        pageState.animateScrollToPage(newPosition)
    }
}