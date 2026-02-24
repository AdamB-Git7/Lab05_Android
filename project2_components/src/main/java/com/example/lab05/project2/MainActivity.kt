package com.example.lab05.project2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab05.project2.ui.theme.Lab05Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab05Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MagicScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MagicScreen(modifier: Modifier = Modifier) {
    var userInput by remember { mutableStateOf("") }
    var magicDone by remember { mutableStateOf(false) }

    val imageRes = if (magicDone) R.drawable.second_image else R.drawable.first_image
    val buttonColor = if (magicDone) Color(0xFF2E7D32) else Color(0xFFE53935)
    val buttonText = if (magicDone) "Magic Done" else "Do Your Magic"

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Magic Image",
            modifier = Modifier
                .height(220.dp)
        )

        if (magicDone) {
            Text(
                text = "Hello Compose",
                color = Color.White,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            )
        }

        Button(
            onClick = { magicDone = !magicDone },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text(text = buttonText, color = Color.White)
        }

        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Enter your name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        if (magicDone) {
            Text(
                text = userInput,
                color = Color.White,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            )
        } else {
            Text(
                text = "Result:",
                color = Color.White,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MagicScreenPreview() {
    Lab05Theme {
        MagicScreen()
    }
}
