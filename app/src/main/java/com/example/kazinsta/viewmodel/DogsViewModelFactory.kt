package com.example.kazinsta.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kazinsta.data.DogRepository


class DogsViewModelFactory(private val dogRepository: DogRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DogViewModel(dogRepository) as T
    }
}