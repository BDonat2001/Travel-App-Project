package com.example.travelapp.model

import com.example.travelapp.data.User

sealed class SignUpState {
    object Idle : SignInState()
    object Loading : SignInState()
    data class LoggedIn(val user: User) : SignInState()
    data class Error(val message: String) : SignInState()
    data class SignUpUiState(
        val name: String = "",
        val email: String = "",
        val password: String = ""
    )
}