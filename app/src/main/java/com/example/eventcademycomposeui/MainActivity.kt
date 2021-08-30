package com.example.eventcademycomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.eventcademycomposeui.ui.HomeScreen
import com.example.eventcademycomposeui.ui.theme.EventCademyComposeUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventCademyComposeUiTheme {
                HomeScreen()
            }
        }
    }
}
@Composable
fun MyBottomNavigationBar(){
    //val navController = rememberNavc
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    EventCademyComposeUiTheme {
        HomeScreen()
    }
}