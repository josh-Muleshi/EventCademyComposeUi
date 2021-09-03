package com.example.eventcademycomposeui.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(context: Context){
    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxSize()
    ){
        MyRecyclerView{
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun MyRecyclerView(selectedItem : (String) -> (Unit)){
    LazyColumn{
        items(100){
            Text(
                text = "User name $it",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(10.dp)
                    .clickable { selectedItem("$it selected") }
            )
            Divider(color = Color.Black, thickness = 3.dp)
        }
    }
}