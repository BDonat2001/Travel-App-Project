package com.example.myapplication.Screens

import android.util.Log
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.Model.SearchViewModel


@Composable
fun Search(viewModel: SearchViewModel, navController: NavController) {
    val searchState by viewModel.searchState.collectAsState("")
    val locations by viewModel.locations.collectAsState(emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(
            text = searchState,
            onTextChange = { viewModel.onSearchTextChanged(it)},
            navController
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Your favorites", style = MaterialTheme.typography.titleMedium)
        Text(text = "Relive the feeling",style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(4.dp))
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
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Last Viewed",style = MaterialTheme.typography.titleMedium)
        Text(text = "Rediscover and get to know more",style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(4.dp))
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
                        text="Budapest"
                        Text(text = "Budapest",textAlign = TextAlign.Center)}
                    else if(it==2){
                        text="Vienna"
                        Text(text = "Vienna",textAlign = TextAlign.Center)}
                    else{
                        text="Rome"
                        Text(text = "Rome",textAlign = TextAlign.Center)
                    }
                    Box(modifier = Modifier
                        .matchParentSize()
                        .clickable { navController.navigate(text) })
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

    }
}
@Composable
fun SearchBar(text: String, onTextChange: (String) -> Unit,navController: NavController) {
    TextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text("Search Location") },
        modifier = Modifier
            .fillMaxWidth()
            .onKeyEvent {
                if (it.key == Key.Enter && it.type == KeyEventType.KeyUp) {
                    Log.d("searchbar",text)
                    if (text=="Budapest\n"){
                        navController.navigate("Budapest")
                    }
                    else if(text=="Vienna\n"){
                        navController.navigate("Vienna")
                    }
                    else if(text=="Rome\n"){
                        navController.navigate("Rome")
                    }
                    return@onKeyEvent true
                }
                return@onKeyEvent false
            }
    )
}