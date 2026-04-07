package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import kotlinx.coroutines.delay
import com.example.myapplication2.ui.theme.MyApplication2Theme

class CA1Activity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplication2Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(true) {
        delay(2000)
        navController.navigate("dashboard") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("My Learning App", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {

        composable("splash") {
            SplashScreen(navController)
        }

        composable("dashboard") {
            DashboardScreen()
        }
    }
}

@Composable
fun DashboardScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            val intent = Intent(context, CA1Activity2::class.java)
            intent.putExtra("course", "Android Development")
            intent.putExtra("duration", "3 Months")
            context.startActivity(intent)
        }) {
            Text("Go to Course Details")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview11() {
    MyApplication2Theme {
        DashboardScreen()
    }
}