package com.example.travelapp

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.example.travelapp.data.repositories.AuthRepository
import com.example.travelapp.view.HomeScreen
import com.example.travelapp.view.SignInScreen
import com.example.travelapp.view.SignUpScreen
import com.example.travelapp.view.WelcomeScreen

@Composable
fun TravelApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Crossfade(targetState = TravelAppNavHost.currentscreen) {currentState->
            when(currentState.value){
                is Screen.SignUpScreen ->{
                    SignUpScreen()
                }
                is Screen.SignInScreen ->{
                    SignInScreen()
                }
                is Screen.WelcomeScreen ->{
                    WelcomeScreen()
                }
                is Screen.HomeScreen ->{
                    HomeScreen()
                }
            }

        }

    }


}

sealed class Screen{
    object SignUpScreen: Screen()
    object SignInScreen: Screen()
    object WelcomeScreen: Screen()
    object HomeScreen: Screen()
}

object TravelAppNavHost{
    val currentscreen: MutableState<Screen> = mutableStateOf(Screen.WelcomeScreen)

    fun navigateTo(destination: Screen){
        currentscreen.value=destination
    }
}