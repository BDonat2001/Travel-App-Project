package com.example.myapplication.Screens.Locations.Rome

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
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
fun Rome(navController:NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Rome",modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center) },
            actions = {
                IconButton(onClick = { navController.navigate("search") }) {
                    Icon(Icons.Outlined.Search, contentDescription = "Back to Search")
                }
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.placeholder),
            contentDescription = "Rome Image"
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Rome", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Description of Rome...Lorem Ipsun etc stb adadaaeea awddad asdad ad fg aedfad ad", modifier = Modifier.width(200.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {navController.navigate("map")/*TODO: show Rome on Map,*/}) {
            Icon(Icons.Filled.Map, contentDescription = "Show on Map")
            Text(text = "See on Map")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Things to DO", style = MaterialTheme.typography.titleLarge)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            // Placeholder for each place item
            repeat(3) {
                Box(
                    modifier = Modifier
                        .width(110.dp)
                        .height(160.dp)
                        .padding(4.dp),
                ) {
                    var text=""
                    if(it==1){
                        text="attractionBP"
                        Text(text = "attractionRome",textAlign = TextAlign.Center)}
                    else if(it==2){
                        text="restaurantBP"
                        Text(text = "restaurantRome",textAlign = TextAlign.Center)}
                    else{
                        text="parkBP"
                        Text(text = "parkRome",textAlign = TextAlign.Center)
                    }
                    Box(modifier = Modifier
                        .matchParentSize()
                        .clickable { /*navController.navigate(text)*/ })
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}