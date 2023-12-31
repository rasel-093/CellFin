package com.example.cellfin

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cellfin.model.TrxViewModel
import com.example.cellfin.screens.HomeScreen
import com.example.cellfin.screens.LoginScreen
import com.example.cellfin.screens.Splash
import com.example.cellfin.ui.theme.CellFinTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CellFinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val trxViewModel: TrxViewModel = viewModel(
                        factory = object : ViewModelProvider.Factory{
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return TrxViewModel(applicationContext as Application) as  T
                            }
                        }
                    )
                    navigation(trxViewModel)
                }
            }
        }
    }
}

@Composable
fun navigation(trxViewModel: TrxViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash"){
        composable("splash"){
            SplashScreen(navController = navController)
        }
        composable("login"){
            LoginScreen(navController = navController)
        }
        composable("home"){
            HomeScreen(navController = navController, trxViewModel)
        }
        composable("statement"){

        }
    }
}

@Composable
fun SplashScreen(navController:NavController){
    LaunchedEffect(key1 = true){
        delay(1000L)
        navController.navigate("login")
    }
    Splash()
}