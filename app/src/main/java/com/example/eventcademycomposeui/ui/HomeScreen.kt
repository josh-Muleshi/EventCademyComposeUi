package com.example.eventcademycomposeui.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.eventcademycomposeui.data.PostItemList
import com.example.eventcademycomposeui.model.PostItem


@Composable
fun HomeScreen(context: Context){
    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxSize()
    ){
        DisplayPostItem{
            Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
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
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it selected") }
            )
            Divider(color = Color.Black, thickness = 3.dp)
        }
    }
}

@Composable
fun DisplayPostItem(selectedItem: (PostItem) -> Unit){

    val postItems = remember{ PostItemList.postItems }

    LazyColumn(
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp
    )){
        items(
            items = postItems,
            itemContent = {
                PostItemListItems(postItem = it, selectedItem = selectedItem)
            }
        )
    }
}

@Composable
fun PostItemListItems(postItem: PostItem, selectedItem: (PostItem) -> Unit){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .clickable { selectedItem(postItem) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            PostItemImage(postItem = postItem)
            Column {
                Text(
                    text = postItem.name,
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = postItem.overview,
                    style = MaterialTheme.typography.body1,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = postItem.year.toString(), style = MaterialTheme.typography.h5)
                    Text(text = postItem.rating.toString(), style = MaterialTheme.typography.h5)
                }
            }
        }
    }
}

@Composable
private fun PostItemImage(postItem: PostItem){
    Image(
        painter = painterResource(id = postItem.imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(4.dp)
            .height(140.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
    )
}