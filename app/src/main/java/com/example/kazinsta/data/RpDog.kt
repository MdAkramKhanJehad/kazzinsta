package com.example.kazinsta.data

import com.google.gson.annotations.SerializedName

data class RpDog(

	@field:SerializedName("message")
	val message: List<String?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)
