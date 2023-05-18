package com.kulik.rabi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kulik.rabi.ui.theme.RabiTheme
import com.kulik.rabi.ui.theme.ui.theme.PurpleGrey80

class PoetsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RabiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PoetsCard()
                }
            }
        }
    }
}

@Composable
fun PoetsCard() {
    val poets = listOf<String>(
        "রবীন্দ্রনাথ ঠাকুর",
        "কাজী নজরুল ইসলাম",
        "জীবনানন্দ দাশ",
        "সুকান্ত ভট্টাচার্য",
        "সুকুমার রায়",
        "জসীমউদ্দীন",
        "আহসান হাবীব",
        "সত্যেন্দ্রনাথ দত্ত",
        "ফররুখ আহমদ",
        "ঈশ্বরচন্দ্র গুপ্ত"
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        poets.forEach { poet ->
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(PurpleGrey80)
                    .border(
                        width = 10.dp, brush = Brush.linearGradient(
                            0.0f to Color.Red,
                            0.3f to Color.Green,
                            1.0f to Color.Blue,
                            start = Offset(0.0f, 50.0f),
                            end = Offset(0.0f, 100.0f)
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp)
                    .height(75.dp)
                    .fillMaxWidth()
            ) {

                Text(
                    text = poet,
                    style = androidx.compose.ui.text.TextStyle(fontSize = 32.sp),
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

    }

}
