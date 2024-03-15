package com.example.travelapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelapp.data.repositories.AuthRepository
import com.example.travelapp.intent.SignInIntent
import com.example.travelapp.model.SignInState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow<SignInState>(SignInState.Idle)
    val state: StateFlow<SignInState> = _state.asStateFlow()

    fun dispatch(intent: SignInIntent) {
        when (intent) {
            is SignInIntent.Login -> login(intent.email, intent.password)
            is SignInIntent.ForgotPassword -> forgotPassword(intent.email)
            else -> throw IllegalStateException("Unknown intent: $intent")
        }
    }

    private fun login(email: String, password: String) {
        viewModelScope.launch {
            _state.value = SignInState.Loading
            try {
                val user = authRepository.login(email, password)
                _state.value = SignInState.LoggedIn(user)
            } catch (e: Exception) {
                _state.value = SignInState.Error(e.localizedMessage ?: "Login failed")
            }
        }
    }

    private fun forgotPassword(email: String) {
        viewModelScope.launch {

        }
    }
}

