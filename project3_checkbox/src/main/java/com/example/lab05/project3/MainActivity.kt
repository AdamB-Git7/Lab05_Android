package com.example.lab05.project3

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
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
import com.example.lab05.project3.ui.theme.Lab05Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab05Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckboxScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CheckboxScreen(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf("None") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0C78D6))
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "What is your gender?",
            color = Color.White,
            modifier = Modifier
                .background(Color(0xFF9E9E9E))
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = selected == "Male",
                onCheckedChange = { checked ->
                    selected = if (checked) "Male" else "None"
                }
            )
            Text(text = "Male", color = Color.White)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = selected == "Female",
                onCheckedChange = { checked ->
                    selected = if (checked) "Female" else "None"
                }
            )
            Text(text = "Female", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Selected: $selected", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxScreenPreview() {
    Lab05Theme {
        CheckboxScreen()
    }
}
