package com.example.myapplication.Model

import androidx.lifecycle.ViewModel
import com.example.myapplication.Location
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel: ViewModel() {

    private val _searchState = MutableStateFlow("")
    val searchState = _searchState.asStateFlow()

    private val _locations = MutableStateFlow<List<Location>>(
        listOf(
            Location("Budapest"),
            Location("Rome"),
            Location("Vienna")
        )
    )
    val locations = _locations.asStateFlow()

    fun onSearchTextChanged(text: String) {
        _searchState.value = text
    }

}