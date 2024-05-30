package com.example.myapplication.Model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CreateListViewModel: ViewModel() {

        private val _locationname = MutableStateFlow("")
        val locationname: StateFlow<String> = _locationname

        private val _description = MutableStateFlow("")
        val description: StateFlow<String> = _description

        private val _category = MutableStateFlow("")
        val category: StateFlow<String> = _category

        fun onListNameChange(newName: String) {
            _locationname.value = newName
        }

        fun onDescriptionChange(newDescription: String) {
            _description.value = newDescription
        }

        fun onCategoryChange(newCategory: String) {
            _category.value = newCategory
        }

        fun saveLocation() {
            // ... save logic
        }
}
