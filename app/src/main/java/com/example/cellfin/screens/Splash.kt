package com.example.cellfin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cellfin.R

@Composable
fun Splash(){
    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()){
        Column (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.8f), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
            Image(painter = painterResource(id = R.drawable.cellfin), contentDescription = "Logo", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        }

        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            Text(text = "Version 3.0.5")
            Text(text = "Copyright © IBBL", fontSize = 24.sp, color =  Color(26, 102, 66))
            Spacer(modifier = Modifier.heightIn(20.dp))
        }
    }
}

@Preview
@Composable
fun PSplash(){
    Splash()
}