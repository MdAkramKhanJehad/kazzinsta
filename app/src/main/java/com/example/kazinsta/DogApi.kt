package com.example.kazinsta

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {

//    @GET("/api/breeds/image/random")
//    suspend fun getRandomDogImage() : Response<Dog>

    @GET("/api/breeds/image/random/{count}")
    suspend fun getMultipleRandomDogImage(@Path("count") count: Int) : Response<RpDog>

    @GET("/api/breed/{breedName}/images")
    suspend fun getAllDogImageByBreed(@Path("breedName") breedName: String) : Response<RpDog>

    @GET("/api/breed/{breedName}/images/random/{count}")
    suspend fun getMultipleRandomDogImageByBreed(@Path("breedName") breedName: String, @Path("count") count: Int) : Response<RpDog>
}