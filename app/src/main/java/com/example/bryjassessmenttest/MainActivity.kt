package com.example.bryjassessmenttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bryjassessmenttest.ui.theme.BryjAssessmentTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BryjAssessmentTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    SimpleListingView()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun SimpleListingView(){
        LazyColumn(Modifier.fillMaxSize()) {
            items(30) {
                RowItems(item = it)
            }
    }
}

@Composable
fun RowItems(item : Int){
    Column(modifier= Modifier.height(50.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "Hello $item",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = Color.Black
            )
        )
    }
    Divider(
        thickness = 1.dp,
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true,backgroundColor = 0xFFFFFFFF)
@Composable
fun GreetingPreview() {
    BryjAssessmentTestTheme {
        SimpleListingView()
    }
}