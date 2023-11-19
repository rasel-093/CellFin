package com.example.cellfin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cellfin.model.TrxItem
import com.example.cellfin.model.trxList
import com.example.cellfin.ui.theme.CellFinTheme
import com.example.cellfin.ui.theme.fontWhite
import com.example.cellfin.ui.theme.primaryColor

class StatementListActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CellFinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = { TopBar()}
                    ) {paddingValues ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            HeadingContent(paddingValues)
                            Column(
                                modifier = Modifier
                                    .padding(15.dp)
                                    .verticalScroll(rememberScrollState())
                            ) {
                                trxList.forEach {item->
                                    TrxItemCard(trxItem = item )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HeadingContent(padding: PaddingValues) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .background(Color(0xFF398661))
    ) {
        HeadingText(text = "CellFin")
        HeadingText(text = "01618 964 627")
        HeadingText(text = "19/10/2023 to 19/11/2023")
    }
}

@Composable
fun HeadingText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        color = fontWhite,
        //modifier = Modifier.padding(4.dp)
        )
}

@Composable
fun TrxItemCard(trxItem: TrxItem) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.75f),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "${trxItem.title}, ${trxItem.details}",
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
                Text(
                    text = "Trx ID: ${trxItem.trxId}",
                    color = Color.Gray
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = "${trxItem.date}",
                    color = Color.Gray
                )
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = if(!trxItem.type()) "-${trxItem.amount}" else "+${trxItem.amount}",
                        color = if(!trxItem.type()) Color.Red else Color(0xFF398661),
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.right_arrow_icon) ,
                        contentDescription = null,
                        modifier = Modifier.padding(4.dp),
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}


