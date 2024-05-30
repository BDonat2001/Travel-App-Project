package com.example.myapplication.Model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpViewModel: ViewModel() {
    val nameState = mutableStateOf("")
    val emailState = mutableStateOf("")
    val passwordState = mutableStateOf("")

    fun onNameChange(newName: String) {
        nameState.value = newName
    }

    fun onEmailChange(newEmail: String) {
        emailState.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        passwordState.value = newPassword
    }

    // Sign-up logic with validation and error handling
    fun signUp(onSignUp:() -> Unit) {
        val email = emailState.value.trim()
        val password = passwordState.value.trim()

        if (email.isEmpty() || password.isEmpty()) {
            // Handle empty email or password error
            return
        }

        if(Firebase.auth.createUserWithEmailAndPassword(email, password).isComplete){

            onSignUp()
        }
    }
}