package com.example.travelapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travelapp.Screen
import com.example.travelapp.TravelAppNavHost
import com.example.travelapp.components.AuthButtonComponent
import com.example.travelapp.components.BackComponent
import com.example.travelapp.components.CheckBoxComponent
import com.example.travelapp.components.ClickableTextComponentAuth
import com.example.travelapp.components.HeadingTextComponent
import com.example.travelapp.components.NormalTextComponent
import com.example.travelapp.components.OutlinedPasswordTextFieldComponent
import com.example.travelapp.components.SimpleOutlinedTextFieldComponent
import com.example.travelapp.data.repositories.AuthRepository
import com.example.travelapp.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen() {
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            BackComponent()
            HeadingTextComponent(value = "Let's Get Started")
            NormalTextComponent(value = "Fill out the form to continue")

            Spacer(modifier = Modifier.height(16.dp))

            SimpleOutlinedTextFieldComponent(labelValue = "Name")
            Spacer(modifier = Modifier.height(8.dp))
            SimpleOutlinedTextFieldComponent(labelValue = "Email")
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedPasswordTextFieldComponent(labelValue = "Password")
            Spacer(modifier = Modifier.height(8.dp))
            CheckBoxComponent(textValue = "By Signing up, you agree to the Terms of Service \n" +
                    "and Privacy Policy")

            Spacer(modifier = Modifier.height(186.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                AuthButtonComponent(textValue = "Sign Up",
                    onClick = {TravelAppNavHost.navigateTo(Screen.HomeScreen)})
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ){
                ClickableTextComponentAuth(value = "Sign In",
                    onTextSelected = {
                        TravelAppNavHost.navigateTo(Screen.SignInScreen)
                    })
            }

        }
    }
}
@Preview
@Composable
fun SignUpPreview(){
    SignUpScreen()
}
