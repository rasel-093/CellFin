package com.example.cellfin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cellfin.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController){
    var password by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier
            .fillMaxWidth(.8f)
            .fillMaxHeight(.4f), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
            Image(painter = painterResource(id = R.drawable.cellfin), contentDescription = "Logo", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        }
        Column(modifier = Modifier
            .fillMaxWidth(.9f)
            .fillMaxHeight(.5f), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),value =phoneNumber , onValueChange ={phoneNumber = it},keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),  label = { Text(text = "Mobile Number")} , placeholder = { Text(text = "Mobile Number")}, leadingIcon = { Icon(
                imageVector = Icons.Outlined.Phone, contentDescription = "Phone")} )

            OutlinedTextField(modifier = Modifier.fillMaxWidth(),value =password , onValueChange ={password =  it}, label = { Text(text = "CellFin 6 Digit Pin")} , placeholder = { Text(text = "CellFin 6 Digit Pin")}, leadingIcon = { Icon(
                imageVector = Icons.Outlined.Lock, contentDescription = "Phone")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword), visualTransformation = PasswordVisualTransformation(),
                singleLine = true)
            Button(onClick = { navController.navigate("home") }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Color(26, 102, 66)), shape = RoundedCornerShape(5.dp)) {
                Text(text = "Log In")
            }
            Text(text = "Forgot Pin", color =  Color(26, 102, 66), fontWeight = FontWeight.Bold)
        }
    }
}