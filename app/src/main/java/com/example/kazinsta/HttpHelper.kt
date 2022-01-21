package com.example.kazinsta

import android.util.Log
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception


class HttpHelper {

    private lateinit var message: List<String?>

   suspend fun getMultipleRandomDogImage(count : Int) : List<String?> {
        val response  =
            RetrofitInstance.api.getMultipleRandomDogImage(count)

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

    suspend  fun getMultipleRandomDogImageByBreed(breedName: String, count: Int): List<String?> {
        val response  =
            RetrofitInstance.api.getMultipleRandomDogImageByBreed(breedName, count)

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



}