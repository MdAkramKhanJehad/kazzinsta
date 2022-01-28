package com.example.kazinsta.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kazinsta.data.DogRepository

class DogViewModel(private val dogRepository: DogRepository) : ViewModel(){

    suspend fun getMultipleRandomDogImage(count : Int) = dogRepository.getMultipleRandomDogImage(count)

    suspend fun getAllDogImageByBreed(breedName: String) = dogRepository.getAllDogImageByBreed(breedName)

    suspend fun getMultipleRandomDogImageByBreed(breedName: String, count: Int) = dogRepository.getMultipleRandomDogImageByBreed(breedName, count)

    suspend fun getListOfAllBreeds() = dogRepository.getListOfAllBreeds()
}