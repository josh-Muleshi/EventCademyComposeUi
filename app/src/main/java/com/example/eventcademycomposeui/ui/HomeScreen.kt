package com.example.eventcademycomposeui.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eventcademycomposeui.R
import com.example.eventcademycomposeui.ui.theme.*

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxSize()
    ){
        MyRecyclerView()
    }
}

@Composable
fun MyRecyclerView(){
    LazyColumn{
        items(100){
            Text(
                text = "User name $it",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 3.dp)
        }
    }
}