package com.example.travelapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.travelapp.Screen
import com.example.travelapp.TravelAppNavHost
import com.example.travelapp.data.repositories.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignUpViewModel(private val authRepository: AuthRepository) : ViewModel() {

    // State variables for user input (optional)
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    // State variable for any error message during signup
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    // State variable for loading state (optional)
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    suspend fun signUp() {
        _isLoading.value = true

        val nameValue = _name.value.trim()
        val emailValue = _email.value.trim()
        val passwordValue = _password.value.trim()

        // Basic validation (optional)
        if (nameValue.isEmpty()) {
            _errorMessage.value = "Please enter your name"
            _isLoading.value = false
            return
        }

        if (emailValue.isEmpty() || !isValidEmail(emailValue)) {
            _errorMessage.value = "Please enter a valid email"
            _isLoading.value = false
            return
        }

        if (passwordValue.isEmpty() || passwordValue.length < 6) {
            _errorMessage.value = "Password must be at least 6 characters"
            _isLoading.value = false
            return
        }

        try {
            val user = authRepository.login(emailValue, passwordValue)

            _errorMessage.value = null

        } catch (e: Exception) {
            _errorMessage.value = "Signup failed: ${e.localizedMessage}"
        } finally {
            _isLoading.value = false
            TravelAppNavHost.navigateTo(Screen.HomeScreen)
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return true
    }
}