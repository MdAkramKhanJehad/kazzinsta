package com.example.kazinsta.data

import android.util.Log

const val TAG="DogRepository"

class DogRepository {

    private lateinit var message: List<String?>
    private lateinit var breedList: Message

    suspend fun getMultipleRandomDogImage(count : Int) : List<String?> {
        val response = RetrofitInstance.api.getMultipleRandomDogImage(count)

        if(response.isSuccessful && response.body() != null){
            message = response.body()!!.message!!
        } else{
            Log.e(TAG, "Response not successful")
        }

        Log.d("Response",response.body().toString())

        return message
    }

    suspend fun getAllDogImageByBreed(breedName: String): List<String?> {
        val response  =
            RetrofitInstance.api.getAllDogImageByBreed(breedName)

        if(response.isSuccessful && response.body() != null){
            message = response.body()!!.message!!
        } else{
            Log.e(TAG, "Response not successful")
        }

        Log.d("Response",response.body().toString())

        return message
    }

    suspend  fun getMultipleRandomDogImageByBreed(breedName: String, count: Int): List<String?> {
        val response  =
            RetrofitInstance.api.getMultipleRandomDogImageByBreed(breedName, count)

        if(response.isSuccessful && response.body() != null){
            message = response.body()!!.message!!
        } else{
            Log.e(TAG, "Response not successful")
        }

        Log.d("Response",response.body().toString())

        return message
    }

    suspend fun getListOfAllBreeds(): Message {
        val response  =
            RetrofitInstance.api.getListOfBreeds()

        if(response.isSuccessful && response.body() != null){
            breedList = response.body()!!.message!!
        } else{
            Log.e(TAG, "Response not successful")
        }

        Log.d("Response",response.body().toString())

        return breedList
    }

    companion object{
        @Volatile private var instance: DogRepository? = null

        fun getInstance() =
            instance ?: synchronized(this){
                instance ?: DogRepository().also { instance = it }
            }
    }


}