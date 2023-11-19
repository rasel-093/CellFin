package com.example.cellfin.screens

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cellfin.R
import com.example.cellfin.StatementListActivity
import com.example.cellfin.ui.theme.fontBlack
import com.example.cellfin.ui.theme.primaryColor
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiniStatementScreen(paddingValues: PaddingValues, context: ComponentActivity) {
//    var fromDate by rememberSaveable{
//        mutableStateOf("19/10/2023")
//    }
//    var toDate by rememberSaveable{
//        mutableStateOf("19/11/2023")
//    }
//    val current = LocalDate.now()

    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formattedCurrentDate = currentDate.format(formatter)
    val prevDate = currentDate.minusDays(30)
    val formattedPrevDate = prevDate.format(formatter)

    var fromDate = formattedPrevDate.toString()
    var toDate = formattedCurrentDate.toString()
    var passWord by rememberSaveable{
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
                SourceCard(text = "CellFin" ,color = Color(0xFF6CDAA3))
                SourceCard(text = "Account", color = Color(0xFFFFFFFF))
                SourceCard(text = "Card", color = Color(0xFFFFFFFF))
                SourceCard(text = "Mobile", color = Color(0xFFFFFFFF))

            }
        }
        PersonCard()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            TextField(text = fromDate,"From Date", onValueChange = {fromDate = it} )
            TextField(text = toDate,"To Date", onValueChange = {toDate = it} )
//            PasswordField(pass = passWord.value, onValueChange ={passWord.value = it} )
            OutlinedTextField(
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.lock_icon),
                        contentDescription = null,
                        tint = Color.Gray
                    )
                },
                value = passWord,
                onValueChange = {passWord = it},
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
        }

        ViewBtn(context = context)

    }
}

@Composable
fun SourceCard(text: String, color: Color) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = color
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
@Composable
fun ViewBtn(context: ComponentActivity) {
    OutlinedButton(
        onClick = {
            val intent = Intent(context,StatementListActivity::class.java)
            context.startActivity(intent)
        },
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