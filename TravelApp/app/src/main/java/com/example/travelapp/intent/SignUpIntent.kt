package com.example.travelapp.intent

sealed class SignUpIntent{
    data class SignUp(val name: String, val email: String, val password: String) : SignUpIntent()
}