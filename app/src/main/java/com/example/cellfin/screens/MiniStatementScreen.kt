package com.example.cellfin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cellfin.R
import com.example.cellfin.ui.theme.fontBlack
import com.example.cellfin.ui.theme.primaryColor

@Composable
fun MiniStatementScreen(paddingValues: PaddingValues) {
    var fromDate = rememberSaveable{
        mutableStateOf("15/11/2023")
    }
    var toDate = rememberSaveable{
        mutableStateOf("21/11/2023")
    }
    var passWord = rememberSaveable{
        mutableStateOf("")
    }
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(top = 10.dp, start = 15.dp, end = 15.dp)
            .background(Color(0xFFFFFFFF))
    ) {
        Column {
            Text(
                text = "Select Source",
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .horizontalScroll(rememberScrollState())
            ){
                SourceCard(text = "CellFin")
                SourceCard(text = "Account")
                SourceCard(text = "Card")
                SourceCard(text = "CellFin")
                SourceCard(text = "M")

            }
        }
        PersonCard()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            TextField(text = fromDate.value,"From Date", onValueChange = {fromDate.value = it} )
            TextField(text = toDate.value,"To Date", onValueChange = {toDate.value = it} )
            PasswordField(pass = passWord.value, onValueChange ={passWord.value = it} )
        }

        ViewBtn()

    }
}

@Composable
fun SourceCard(text: String) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        modifier = Modifier
            .padding(end = 10.dp)
            //.border(BorderStroke(1.dp, Color.Gray))
    ) {
        Text(
            text = text,
            color = fontBlack,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(15.dp)
            )
    }
}


@Composable
fun PersonCard() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
           // .border(BorderStroke(0.5.dp,Color.Gray))

    ) {
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFFFFF)
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter =  painterResource(id = R.drawable.contact_icon),
                    contentDescription = null,
                    tint = primaryColor,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "MD. HIMEL MIA",
                    color = primaryColor,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFFFFF)
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter =  painterResource(id = R.drawable.phone_icon),
                    contentDescription = null,
                    tint = primaryColor,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "01618875691",
                    fontWeight = FontWeight.SemiBold,
                    color = primaryColor,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(text: String, label:String, onValueChange: (String)->Unit) {
        OutlinedTextField(
            value = text,
            onValueChange = {onValueChange},
            label = {
                Text(
                    text = label,
                    color = Color.Gray
            )},
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.calendar_icon),
                    contentDescription = null,
                    tint = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(pass: String,onValueChange: (String) -> Unit) {
    OutlinedTextField(
        leadingIcon = {
                      Icon(
                          painter = painterResource(id = R.drawable.lock_icon),
                          contentDescription = null,
                          tint = Color.Gray
                      )
        },
        value = pass,
        onValueChange = {onValueChange},
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.eye_icon),
                contentDescription = null ,
                tint = Color.Gray
                )
        },
        label = {
            Text(
                text = "CellFin 6 Digit Pin",
                color = Color.Gray)
                },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    )
}

@Composable
fun ViewBtn() {
    OutlinedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = primaryColor,
            contentColor = Color(0xFFFFFFFF)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Text(
            text = "View",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(5.dp)
        )
    }
}