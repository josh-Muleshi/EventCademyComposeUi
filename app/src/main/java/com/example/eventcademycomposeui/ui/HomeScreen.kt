package com.example.eventcademycomposeui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.example.eventcademycomposeui.R
import com.example.eventcademycomposeui.ui.theme.*

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxSize()
    ){
        Column {
            HeadSection()
        }
    }
}

@Composable
fun HeadSection(
    name: String = "Josh",
){
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    listOf(ButtonBlue, BlueGradient)
                )
            )

    ) {

        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .padding(top = 10.dp, bottom = 40.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .size(width = 40.dp, height = 40.dp)
                        .border(width = 3.dp, color = Color.White, shape = CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_profil),
                        contentDescription = "profile"
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(top = 30.dp)
                ) {
                    Text(
                        text = "Welcome back,",
                        color = TextsubWhite,
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "$name",
                        color = TextWhite,
                        style = MaterialTheme.typography.h5,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .size(width = 50.dp, height = 50.dp)
                    .border(width = 3.dp, color = Color.White, shape = CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profil),
                    contentDescription = "profile"
                )
            }

            /*Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )*/

            //ubuntu
        }

    }
}


