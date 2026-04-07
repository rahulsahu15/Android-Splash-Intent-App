package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication2.ui.theme.MyApplication2Theme

class CA1Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val course = intent.getStringExtra("course")
        val duration = intent.getStringExtra("duration")

        setContent {
            MyApplication2Theme {
                SecondScreen(
                    course = course,
                    duration = duration,
                    onBack = { finish() }
                )
            }
        }
    }
}

@Composable
fun SecondScreen(
    course: String?,
    duration: String?,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Course: ${course ?: "Not Available"}")
        Text("Duration: ${duration ?: "Not Available"}")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { onBack() }) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    MyApplication2Theme {
        SecondScreen(
            course = "Android Development",
            duration = "3 Months",
            onBack = {}
        )
    }
}