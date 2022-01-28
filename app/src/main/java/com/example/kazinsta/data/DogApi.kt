package com.example.kazinsta.data

import com.example.kazinsta.data.RpBreed
import com.example.kazinsta.data.RpDog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {
    @GET("/api/breeds/list/all")
    suspend fun getListOfBreeds() : Response<RpBreed>

    @GET("/api/breeds/image/random/{count}")
    suspend fun getMultipleRandomDogImage(@Path("count") count: Int) : Response<RpDog>

    @GET("/api/breed/{breedName}/images")
    suspend fun getAllDogImageByBreed(@Path("breedName") breedName: String) : Response<RpDog>

    @GET("/api/breed/{breedName}/images/random/{count}")
    suspend fun getMultipleRandomDogImageByBreed(@Path("breedName") breedName: String, @Path("count") count: Int) : Response<RpDog>
}