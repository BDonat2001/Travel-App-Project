package com.example.myapplication.Model

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class SignInViewModel : ViewModel() {
    val emailState = mutableStateOf("")
    val passwordState = mutableStateOf("")

    fun onEmailChange(newEmail: String) {
        emailState.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        passwordState.value = newPassword
    }

    fun signIn(onSignIn: () -> Unit ) {
        val email = emailState.value.trim()
        val password = passwordState.value.trim()

        if (email.isEmpty() || password.isEmpty()) {
            // Handle empty email or password error
            return
        }
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if(it.isComplete){
                    onSignIn()
                }
            }
    }
}