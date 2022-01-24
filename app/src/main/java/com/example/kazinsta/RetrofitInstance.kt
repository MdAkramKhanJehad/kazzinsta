package com.example.kazinsta

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    val api: DogApi by lazy {

        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder()
        client.addInterceptor(logger)

        Retrofit.Builder()
            .baseUrl("https://dog.ceo")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
            .create(DogApi::class.java)
    }
}