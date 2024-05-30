package com.example.myapplication.Screens

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.Components.CheckBoxComponent
import com.example.myapplication.Model.SignInViewModel
import kotlinx.coroutines.launch
@Composable
fun SignIn(
    viewModel: SignInViewModel,
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
        Text(text = "Sign In", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.emailState.value,
            onValueChange = {viewModel.onEmailChange(it)},
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.passwordState.value,
            onValueChange = {viewModel.onPasswordChange(it)},
            label = { Text("Password") },
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(0.5f)

            ){
                CheckBoxComponent(textValue = "Remember me next time")
            }
            Text(
                text = "reset password",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { /* Handle reset password navigation */ }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            isLoading=true
            viewModel.signIn(){
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
            Text(text = "Don't have an account? ")
            Text(
                text = "Sign Up",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { navController.navigate("signup")}
            )
        }
    }
}