package com.example.bryjassessmenttest

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bryjassessmenttest.ui.theme.BryjAssessmentTestTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

@SuppressLint("SuspiciousIndentation")
@Composable
fun SimpleListingView(){

    val scope = rememberCoroutineScope()
    var concatItemList = mutableListOf<String>()

        LazyColumn(Modifier.fillMaxSize()) {
            items(30) {
                RowItems(item = it, onClickItem = { itemText->
                    scope.launch {
//                        delay(3000)
                        concatItemList.add(itemText)
                        concatItemList.map {
                            Log.e("item :", it)
                        }
                    }
                })
            }
    }
}

@Composable
fun RowItems(item : Int,onClickItem : (String) -> Unit){
    Column(modifier= Modifier.height(50.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier
                .padding(start = 10.dp)
                .clickable { onClickItem("Hello $item") },
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