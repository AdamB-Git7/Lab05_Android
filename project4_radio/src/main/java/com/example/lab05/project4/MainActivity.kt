package com.example.lab05.project4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab05.project4.ui.theme.Lab05Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab05Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RadioScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RadioScreen(modifier: Modifier = Modifier) {
    val options = listOf("Red", "Green", "Yellow", "Gray")
    var selected by remember { mutableStateOf(options.first()) }
    var backgroundColor by remember { mutableStateOf(Color.White) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Select a Color:")

        options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selected == option,
                    onClick = { selected = option }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option)
            }
        }

        Button(
            onClick = {
                backgroundColor = when (selected) {
                    "Red" -> Color.Red
                    "Green" -> Color.Green
                    "Yellow" -> Color.Yellow
                    "Gray" -> Color.Gray
                    else -> Color.White
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5A6EA6))
        ) {
            Text(text = "Change Background Color", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioScreenPreview() {
    Lab05Theme {
        RadioScreen()
    }
}
