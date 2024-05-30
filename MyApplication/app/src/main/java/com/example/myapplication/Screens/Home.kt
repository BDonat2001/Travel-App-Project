package com.example.myapplication.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Attractions
import androidx.compose.material.icons.outlined.Hotel
import androidx.compose.material.icons.outlined.Park
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Top bar
        TopAppBar(
            title = { Text(text = "App Name",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center) }
            )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(
                onClick = { /* TODO: Hotel action */ },
                modifier = Modifier.width(144.dp),
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onSurface)
            ) {
                Row {
                    Icon(Icons.Outlined.Hotel , contentDescription = "Hotels")
                    Text(text = "Hotels", style = MaterialTheme.typography.labelMedium)
                }
            }
            OutlinedButton(
                onClick = { /* TODO: Restaurant action */ },
                modifier = Modifier.width(144.dp),
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onSurface)
            ) {
                Row {
                    Icon(Icons.Outlined.Restaurant, contentDescription = "Restaurants")
                    Text(text = "Restaurants", style = MaterialTheme.typography.labelMedium)
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(
                onClick = { /* TODO: Parks action */ },
                modifier = Modifier.width(144.dp),
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onSurface)
            ) {
                Row {
                    Icon(Icons.Outlined.Park, contentDescription = "Parks")
                    Text(text = "Parks", style = MaterialTheme.typography.labelMedium)
                }
            }
            OutlinedButton(onClick = { /* TODO: Attractions action */ },
                modifier = Modifier.width(144.dp),
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onSurface)
            ) {
                Row {
                    Icon(Icons.Outlined.Attractions, contentDescription = "Attractions")
                    Text(text = "Attractions", style = MaterialTheme.typography.labelMedium)
                }
            }
        }

        // Last viewed section
        Column( modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text(text = "Last Viewed", style = MaterialTheme.typography.titleMedium)
            Text(text = "Get back to what you were doing last time", style = MaterialTheme.typography.bodyMedium)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center

        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Icon(Icons.Outlined.PlayArrow, contentDescription = "Last viewed activity",
                    modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    // Placeholder for last viewed activity title
                    Text(text = "Placeholder title",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)
                    Image(painter = painterResource(id = R.drawable.placeholder), contentDescription = "last Viewed")
                }
            }
            Box(modifier = Modifier
                .matchParentSize()
                .clickable { navController.navigate("Budapest") })
        }

        // You might like near you section
        Text(
            text = "Things to do near you",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        // Horizontal list of places
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            // Placeholder for each place item
            repeat(3) {
                Card(
                    modifier = Modifier
                        .width(110.dp)
                        .height(160.dp)
                        .padding(4.dp),
                ) {
                    Text(text = "placeholder",textAlign = TextAlign.Center)
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

    }
}
