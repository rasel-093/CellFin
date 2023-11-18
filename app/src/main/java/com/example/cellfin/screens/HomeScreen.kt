package com.example.cellfin.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cellfin.Components.Carousel
import com.example.cellfin.R
import com.example.cellfin.StatementActivity
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavController){
    val context = LocalContext.current

    Column (modifier = Modifier.fillMaxWidth()){
        Row(modifier = Modifier
            .background(Color(26, 102, 66))
            .fillMaxWidth()
            .height(60.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            Spacer(modifier = Modifier.width(2.dp))
            Column(modifier = Modifier.fillMaxWidth(.8f)) {
                Image(painter = painterResource(id = R.drawable.toplogoo), contentDescription = "Logo", modifier = Modifier
                    .clip(
                        RoundedCornerShape(5.dp)
                    ))
            }
            Image(painter = painterResource(id = R.drawable.bell), contentDescription = "Logo", modifier = Modifier.fillMaxHeight(.5f), contentScale = ContentScale.FillHeight)

            Image(painter = painterResource(id = R.drawable.logout), contentDescription = "Logo", modifier = Modifier.fillMaxHeight(.5f), contentScale = ContentScale.FillHeight)
            Spacer(modifier = Modifier.width(2.dp))

        }
        Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomEnd) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
            ){
                Image(painter = painterResource(id = R.drawable.header_1), contentDescription = "Header", contentScale = ContentScale.FillWidth, modifier = Modifier.fillMaxWidth())
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth(.95f)
                        .height(70.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "MD. HIMEL MIA", modifier = Modifier.fillMaxWidth(.5f))
                        Button(onClick = { /*TODO*/ },modifier = Modifier.fillMaxWidth(.8f), colors = ButtonDefaults.buttonColors(containerColor = Color(245,198,34))) {
                            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                                Image(painter = painterResource(id = R.drawable.taka), contentDescription = "taka")
                                Text(text = "Balance")
                            }
                        }
                    }

                    Image(painter = painterResource(id = R.drawable.group2), contentDescription = "One", modifier = Modifier
                        .fillMaxWidth(.95f)
                        .shadow(5.dp, RoundedCornerShape(10.dp), clip = true), contentScale = ContentScale.FillWidth)

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(painter = painterResource(id = R.drawable.group3), contentDescription = "One", modifier = Modifier
                        .fillMaxWidth(.95f)
                        .shadow(5.dp, RoundedCornerShape(10.dp), clip = true), contentScale = ContentScale.FillWidth)

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(painter = painterResource(id = R.drawable.group1), contentDescription = "One", modifier = Modifier
                        .fillMaxWidth(.95f)
                        .shadow(5.dp, RoundedCornerShape(10.dp), clip = true), contentScale = ContentScale.FillWidth)
                    Spacer(modifier = Modifier.height(20.dp))

                    Carousel()

                    Spacer(modifier = Modifier.height(60.dp))
                }
            }
            Row(){
                Image(
                    painter = painterResource(id = R.drawable.buttombar),
                    contentDescription = "One",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                              val intent = Intent(context,StatementActivity::class.java)
                              context.startActivity(intent)
                        },
                    contentScale = ContentScale.FillWidth)
            }
        }


    }
}
