package com.example.travelapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelapp.Screen
import com.example.travelapp.TravelAppNavHost
import com.example.travelapp.components.HeadingTextComponent
import com.example.travelapp.components.ImageCardComponent
import com.example.travelapp.components.NormalTextComponent
import com.example.travelapp.components.WelcomeScreenButtonComponent

@Composable
fun WelcomeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){

        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(64.dp))
            HeadingTextComponent(value = "App Name")
            Spacer(modifier = Modifier.height(16.dp))
            ImageCardComponent()
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                NormalTextComponent(value = "Welcome message!\nLorem ipsum dolor sit amet, \n" +
                        "consectetur adipiscing elit imagine. \n" +
                        "vulputate tempor lobortis. Duis \n" +
                        "aliquet interdum sagittis. Donec pulvinar ")
            }

            Spacer(modifier = Modifier.height(64.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                WelcomeScreenButtonComponent(
                    textValue = "Sign Up",
                    onClick = {TravelAppNavHost.navigateTo(Screen.SignUpScreen)})
            }
            Spacer(modifier = Modifier.height(26.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                WelcomeScreenButtonComponent(
                    textValue = "Sign In",
                    onClick = {TravelAppNavHost.navigateTo(Screen.SignInScreen)})
            }
        }
    }
}

@Preview
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen()
}