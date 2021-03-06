package com.example.kazinsta

import android.util.Log
import com.example.kazinsta.data.Message
import com.example.kazinsta.data.RetrofitInstance
import com.example.kazinsta.data.TAG
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception


class HttpHelper {

    private lateinit var message: List<String?>
    private lateinit var breedList: Message

   suspend fun getMultipleRandomDogImage(count : Int) : List<String?> {
        val response = RetrofitInstance.api.getMultipleRandomDogImage(count)

//        } catch (e: Exception){
//            Log.e(TAG, "IOException, may be no internet")
//        }

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

//        println("TYPE: ${message.javaClass.kotlin.simpleName}")

        Log.d("Response",response.body().toString())

        return breedList
    }



}