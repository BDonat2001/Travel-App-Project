package com.example.myapplication.Model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class ProfileViewModel: ViewModel() {

    val userSignedIn = MutableLiveData<Boolean>(false)
}