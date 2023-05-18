package com.kulik.rabi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.kulik.rabi.ui.theme.ui.theme.RabiTheme

class PoemActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RabiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PoemDisplay()
                }
            }
        }
    }
}

@Composable
fun PoemDisplay() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row() {
            Text("ধান", style = TextStyle(fontSize = 52.sp))
        }
        Row() {
            Text(text = "- করুণাকর প্রধান", style = TextStyle(fontSize = 36.sp))
        }
        Row() {
            Text(text = "ধান কাটি, কাটি ধান \n" +
                    "ধান কাটি, কাটি রে \n" +
                    " কাস্তে নিয়ে চল \n" +
                    " গান গেয়ে চল \n " +
                    "কোদাল নিয়ে চল \n" +
                    " মাঠে মাঠে চল \n" +
                    " ধান কাটি\n", style = TextStyle(fontSize = 16.sp))
        }
    }
}
