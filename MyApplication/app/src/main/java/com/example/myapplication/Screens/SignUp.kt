package com.example.myapplication.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.Components.CheckBoxComponent
import com.example.myapplication.Model.SignUpViewModel

@Composable
fun SignUp(
    viewModel: SignUpViewModel,
    navController: NavController
){
    var passwordVisible by remember {
    mutableStateOf(false)
    }
    var isLoading by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Let's Get Started!", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.nameState.value,
            onValueChange = {viewModel.onNameChange(it)},
            label = { Text("Name") },
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.emailState.value,
            onValueChange = {viewModel.onEmailChange(it)},
            label = { Text("Email") },
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.passwordState.value,
            onValueChange = {viewModel.onPasswordChange(it)},
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                var iconImage = if(passwordVisible){
                    Icons.Filled.Visibility
                }
                else{
                    Icons.Filled.VisibilityOff
                }
                var description = if(passwordVisible){
                    "Hide Password"
                }else{
                    "Show Password"
                }
                IconButton(onClick = {passwordVisible = !passwordVisible}) {
                    Icon(imageVector = iconImage, contentDescription = description )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CheckBoxComponent(textValue = "By Signing up, you agree to the Terms of Service \n" +
                "and Privacy Policy")
        Button(onClick = {
            isLoading=true
            viewModel.signUp(){
                isLoading=false
                navController.navigate("home")} }) {
            if (isLoading) {
                CircularProgressIndicator(color = Color.White) // Show progress indicator while signing in
            } else {
                Text(text = "Sign In")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Already have an account? ")
            Text(
                text = "Sign In",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { navController.navigate("signin") }
            )
        }
    }
}