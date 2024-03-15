package com.example.travelapp.intent

sealed class SignInIntent{
    data class Login(val email: String, val password: String) : SignInIntent()
    data class ForgotPassword(val email: String) : SignInIntent()
}