package com.example.kazinsta.utilies

import com.example.kazinsta.data.DogRepository
import com.example.kazinsta.viewmodel.DogsViewModelFactory

object InjectorUtils {

    fun provideDogsViewModelFactory(): DogsViewModelFactory{
        val dogRepository = DogRepository.getInstance()
        return DogsViewModelFactory(dogRepository)
    }
}