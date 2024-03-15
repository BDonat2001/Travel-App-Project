package com.example.travelapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelapp.Screen
import com.example.travelapp.TravelAppNavHost
import com.example.travelapp.components.AuthButtonComponent
import com.example.travelapp.components.BackComponent
import com.example.travelapp.components.CheckBoxComponent
import com.example.travelapp.components.ClickableTextComponentAuth
import com.example.travelapp.components.HeadingTextComponent
import com.example.travelapp.components.NormalTextComponent
import com.example.travelapp.components.OutlinedPasswordTextFieldComponent
import com.example.travelapp.components.ResetPasswordText
import com.example.travelapp.components.SimpleOutlinedTextFieldComponent
import com.example.travelapp.data.repositories.AuthRepository

@Composable
fun SignInScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            BackComponent()
            HeadingTextComponent(value = "Welcome back")
            NormalTextComponent(value = "Use your credentials to continue")

            Spacer(modifier = Modifier.height(120.dp))
            SimpleOutlinedTextFieldComponent(labelValue = "Email")
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedPasswordTextFieldComponent(labelValue = "Password")
            ResetPasswordText()
            CheckBoxComponent(textValue = "Remember me next time")
            Spacer(modifier = Modifier.height(200.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                AuthButtonComponent(textValue = "Sign In",
                    onClick = {TravelAppNavHost.navigateTo(Screen.HomeScreen)})
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ){
                ClickableTextComponentAuth(value = "Sign Up",
                    onTextSelected = {
                        TravelAppNavHost.navigateTo(Screen.SignUpScreen)
                    })
            }

        }
    }
}
@Preview
@Composable
fun SignInPreview(){
    SignInScreen()
}