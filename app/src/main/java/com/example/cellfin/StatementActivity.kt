package com.example.cellfin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cellfin.screens.MiniStatementScreen
import com.example.cellfin.ui.theme.CellFinTheme
import com.example.cellfin.ui.theme.fontWhite
import com.example.cellfin.ui.theme.primaryColor

class StatementActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CellFinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFFFFF)//MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {TopBar()}
                    ) {paddingValues ->
                        MiniStatementScreen(paddingValues = paddingValues,this)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        navigationIcon = {
                         Icon(
                             painter = painterResource(id =  R.drawable.back_arrow) ,
                             contentDescription = null,
                             tint = Color(0xFFFFFFFF),
                             modifier = Modifier.padding(start = 10.dp)
                         )
        },
        title = {
                Text(
                    text = "Mini Statement",
                    fontWeight = FontWeight.Bold,
                    color = fontWhite,
                    modifier = Modifier.padding(horizontal = 35.dp)
                )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = primaryColor
        )
    )
}
