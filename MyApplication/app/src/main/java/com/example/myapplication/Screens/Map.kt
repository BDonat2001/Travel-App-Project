package com.example.myapplication.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Map() {
    Column {
        Card(modifier = Modifier.fillMaxSize()) {
            Text(text = "Map")
            Text(text = "Implemented later")
        }
    }
}