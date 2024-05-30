package com.example.myapplication.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Lists() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Top app bar with title
        TopAppBar(
            title = { Text(text = "App Name",modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center) }
        )

        // List creation section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Text(
                    text = "Your Lists",
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = "All the different lists you've created",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Button(
                onClick = { /* TODO: Create new list action */ },
                modifier = Modifier.width(100.dp),
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "New List", color = Color.White)
            }
        }

        // List items
        Column(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .height(150.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(150.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Favorites", style = MaterialTheme.typography.bodyMedium)
                    }
                    Box(modifier = Modifier
                        .matchParentSize()
                        .clickable { /* TODO: Open list action */ })
                }
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(150.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "My favorite chill spots", style = MaterialTheme.typography.bodyMedium)
                    }
                    Box(modifier = Modifier
                        .matchParentSize()
                        .clickable { /* TODO: Open list action */ })
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .height(150.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(150.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "My weekend Getaway", style = MaterialTheme.typography.bodyMedium)
                    }
                    Box(modifier = Modifier
                        .matchParentSize()
                        .clickable { /* TODO: Open list action */ })
                }
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(150.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Summer 2023", style = MaterialTheme.typography.bodyMedium)
                    }
                    Box(modifier = Modifier
                        .matchParentSize()
                        .clickable { /* TODO: Open list action */ })
                }
            }
        }
    }

}