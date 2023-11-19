package com.example.cellfin.screens

import android.app.Application
import android.content.Intent
import android.widget.Toast
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cellfin.Components.Carousel
import com.example.cellfin.R
import com.example.cellfin.StatementActivity
import com.example.cellfin.model.TrxItem
import com.example.cellfin.model.TrxViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, trxViewModel: TrxViewModel){
    val context = LocalContext.current // used in intent
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }


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
                        Text(text = "MD. HIMEL MIA", modifier = Modifier.fillMaxWidth(.5f), fontWeight = FontWeight.SemiBold)
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
                        .shadow(5.dp, RoundedCornerShape(10.dp), clip = true)
                        .clickable { isSheetOpen = true }, contentScale = ContentScale.FillWidth)
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
                            val intent = Intent(context, StatementActivity::class.java)
                            context.startActivity(intent)
                        },
                    contentScale = ContentScale.FillWidth)
            }
        }
    }

    //Bottom sheet
    var title by rememberSaveable { mutableStateOf("") }
    var details by rememberSaveable { mutableStateOf("") }
    var date by rememberSaveable { mutableStateOf("") }
    var trxId by rememberSaveable { mutableStateOf("") }
    var amount by rememberSaveable { mutableStateOf("") }
    var type by rememberSaveable { mutableStateOf("") }

    if(isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isSheetOpen = false },
            //modifier = Modifier.padding(bottom = 50.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp)
            ) {
                OutlinedTextField(
                    value = title,
                    onValueChange = {title = it},
                    label = { Text(text = "Title")},
                    singleLine = true
                )
                OutlinedTextField(
                    value = details,
                    onValueChange = {details = it},
                    label = {Text(text = "Details")},
                    singleLine = true
                )
                OutlinedTextField(
                    value = date,
                    onValueChange = {date = it},
                    label = {Text(text = "Date")},
                    singleLine = true
                )
                OutlinedTextField(
                    value = trxId,
                    onValueChange = {trxId = it},
                    label = {Text(text = "Transaction Id")},
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    singleLine = true
                )
                OutlinedTextField(
                    value = amount,
                    onValueChange = {amount = it},
                    label = {Text(text = "amount")},
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    singleLine = true
                )
                //Add radio button here
                //For cash in -> type = true.toString()
                //For cashout -> type = false.toString()
                val radioOptions = listOf("Cash In","Cash Out")
                var selectedOption by rememberSaveable { mutableStateOf(radioOptions[0]) }
                Row {
                    radioOptions.forEach { type ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = (type == selectedOption),
                                onClick = { selectedOption = type }
                            )
                            Text(
                                text = type,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(0.8f),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    OutlinedButton(
                        onClick = {
                            var trxItem = TrxItem(
                                null,
                                title = title,
                                details = details,
                                date = date,
                                trxId = trxId,
                                amount = amount,
                                trxType = if(selectedOption == radioOptions[0]) true.toString() else false.toString()
                            )
                            trxViewModel.insertTrx(trxItem)
                            Toast.makeText(context,"Transaction Saved",Toast.LENGTH_SHORT).show()
                        }) {
                        Text(text = "Save", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}
