package com.example.myapplication.Screens.Locations.Budapest.restaurants

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.Screens.Locations.Budapest.Location
import com.example.myapplication.Screens.Locations.Budapest.Review

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantBp(location: Location, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = location.title) },
            actions = {
                IconButton(onClick = { navController.navigate("search") }) {
                    Icon(Icons.Outlined.Search, contentDescription = "Back to Search")
                }
                IconButton(onClick = { navController.navigate("lists") }) {
                    Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Favorite")
                }
            }
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.placeholder),
                    contentDescription = "Location Image",
                    modifier = Modifier.fillMaxWidth().height(200.dp)
                )
            }
            item {
                ReviewSection(location.averageRating, location.numReviews)
            }
            item {
                Text(
                    text = "Open Hours",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
                Text(
                    text = location.openHours, // Replace with location open hours
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                Text(
                    text = "Reviews",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
                // Add your reviews list here
                location.reviews.forEach() { review ->
                    ReviewItem(review) // Call a composable to display each review
                }
            }
        }
    }
}

@Composable
fun ReviewSection(averageRating: Int, numReviews: Int) {
    Row(modifier = Modifier.padding(horizontal = 16.dp)) {
        Icon(Icons.Filled.Star,"rating", tint = Color.Yellow, modifier = Modifier.size(16.dp))
        Text(
            text = "$averageRating ($numReviews reviews)",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun ReviewItem(review: Review) {
    Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
        Text(text = review.author, style = MaterialTheme.typography.bodyMedium)
        Text(text = review.text)
        Row(modifier = Modifier.padding(top = 4.dp)) {
            repeat(review.rating) {
                Icon(Icons.Filled.Star,"rating", tint = Color.Yellow, modifier = Modifier.size(16.dp))
            }
            repeat(5 - review.rating) {
                Icon(Icons.Filled.Star,"rating", tint = Color.Yellow, modifier = Modifier.size(16.dp))
            }
        }
    }
}