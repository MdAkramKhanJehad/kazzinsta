package com.example.kazinsta.data

import com.google.gson.annotations.SerializedName

data class RpBreed(

	@field:SerializedName("message")
	val message: Message? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Message(

	@field:SerializedName("pyrenees")
	val pyrenees: List<Any?>? = null,

	@field:SerializedName("affenpinscher")
	val affenpinscher: List<Any?>? = null,

	@field:SerializedName("kuvasz")
	val kuvasz: List<Any?>? = null,

	@field:SerializedName("dingo")
	val dingo: List<Any?>? = null,

	@field:SerializedName("pug")
	val pug: List<Any?>? = null,

	@field:SerializedName("husky")
	val husky: List<Any?>? = null,

	@field:SerializedName("dachshund")
	val dachshund: List<Any?>? = null,

	@field:SerializedName("greyhound")
	val greyhound: List<String?>? = null,

	@field:SerializedName("buhund")
	val buhund: List<String?>? = null,

	@field:SerializedName("deerhound")
	val deerhound: List<String?>? = null,

	@field:SerializedName("appenzeller")
	val appenzeller: List<Any?>? = null,

	@field:SerializedName("schipperke")
	val schipperke: List<Any?>? = null,

	@field:SerializedName("stbernard")
	val stbernard: List<Any?>? = null,

	@field:SerializedName("basenji")
	val basenji: List<Any?>? = null,

	@field:SerializedName("mountain")
	val mountain: List<String?>? = null,

	@field:SerializedName("retriever")
	val retriever: List<String?>? = null,

	@field:SerializedName("beagle")
	val beagle: List<Any?>? = null,

	@field:SerializedName("coonhound")
	val coonhound: List<Any?>? = null,

	@field:SerializedName("dhole")
	val dhole: List<Any?>? = null,

	@field:SerializedName("rottweiler")
	val rottweiler: List<Any?>? = null,

	@field:SerializedName("airedale")
	val airedale: List<Any?>? = null,

	@field:SerializedName("elkhound")
	val elkhound: List<String?>? = null,

	@field:SerializedName("brabancon")
	val brabancon: List<Any?>? = null,

	@field:SerializedName("springer")
	val springer: List<String?>? = null,

	@field:SerializedName("whippet")
	val whippet: List<Any?>? = null,

	@field:SerializedName("mexicanhairless")
	val mexicanhairless: List<Any?>? = null,

	@field:SerializedName("boxer")
	val boxer: List<Any?>? = null,

	@field:SerializedName("labrador")
	val labrador: List<Any?>? = null,

	@field:SerializedName("kelpie")
	val kelpie: List<Any?>? = null,

	@field:SerializedName("pointer")
	val pointer: List<String?>? = null,

	@field:SerializedName("chow")
	val chow: List<Any?>? = null,

	@field:SerializedName("akita")
	val akita: List<Any?>? = null,

	@field:SerializedName("shihtzu")
	val shihtzu: List<Any?>? = null,

	@field:SerializedName("bulldog")
	val bulldog: List<String?>? = null,

	@field:SerializedName("briard")
	val briard: List<Any?>? = null,

	@field:SerializedName("cattledog")
	val cattledog: List<String?>? = null,

	@field:SerializedName("leonberg")
	val leonberg: List<Any?>? = null,

	@field:SerializedName("entlebucher")
	val entlebucher: List<Any?>? = null,

	@field:SerializedName("havanese")
	val havanese: List<Any?>? = null,

	@field:SerializedName("saluki")
	val saluki: List<Any?>? = null,

	@field:SerializedName("collie")
	val collie: List<String?>? = null,

	@field:SerializedName("pekinese")
	val pekinese: List<Any?>? = null,

	@field:SerializedName("bluetick")
	val bluetick: List<Any?>? = null,

	@field:SerializedName("germanshepherd")
	val germanshepherd: List<Any?>? = null,

	@field:SerializedName("weimaraner")
	val weimaraner: List<Any?>? = null,

	@field:SerializedName("schnauzer")
	val schnauzer: List<String?>? = null,

	@field:SerializedName("otterhound")
	val otterhound: List<Any?>? = null,

	@field:SerializedName("australian")
	val australian: List<String?>? = null,

	@field:SerializedName("cockapoo")
	val cockapoo: List<Any?>? = null,

	@field:SerializedName("ovcharka")
	val ovcharka: List<String?>? = null,

	@field:SerializedName("mastiff")
	val mastiff: List<String?>? = null,

	@field:SerializedName("sheepdog")
	val sheepdog: List<String?>? = null,

	@field:SerializedName("eskimo")
	val eskimo: List<Any?>? = null,

	@field:SerializedName("samoyed")
	val samoyed: List<Any?>? = null,

	@field:SerializedName("corgi")
	val corgi: List<String?>? = null,

	@field:SerializedName("malamute")
	val malamute: List<Any?>? = null,

	@field:SerializedName("papillon")
	val papillon: List<Any?>? = null,

	@field:SerializedName("chihuahua")
	val chihuahua: List<Any?>? = null,

	@field:SerializedName("lhasa")
	val lhasa: List<Any?>? = null,

	@field:SerializedName("pembroke")
	val pembroke: List<Any?>? = null,

	@field:SerializedName("spaniel")
	val spaniel: List<String?>? = null,

	@field:SerializedName("clumber")
	val clumber: List<Any?>? = null,

	@field:SerializedName("ridgeback")
	val ridgeback: List<String?>? = null,

	@field:SerializedName("keeshond")
	val keeshond: List<Any?>? = null,

	@field:SerializedName("pitbull")
	val pitbull: List<Any?>? = null,

	@field:SerializedName("dane")
	val dane: List<String?>? = null,

	@field:SerializedName("redbone")
	val redbone: List<Any?>? = null,

	@field:SerializedName("waterdog")
	val waterdog: List<String?>? = null,

	@field:SerializedName("bouvier")
	val bouvier: List<Any?>? = null,

	@field:SerializedName("mix")
	val mix: List<Any?>? = null,

	@field:SerializedName("komondor")
	val komondor: List<Any?>? = null,

	@field:SerializedName("malinois")
	val malinois: List<Any?>? = null,

	@field:SerializedName("cotondetulear")
	val cotondetulear: List<Any?>? = null,

	@field:SerializedName("tervuren")
	val tervuren: List<Any?>? = null,

	@field:SerializedName("puggle")
	val puggle: List<Any?>? = null,

	@field:SerializedName("borzoi")
	val borzoi: List<Any?>? = null,

	@field:SerializedName("poodle")
	val poodle: List<String?>? = null,

	@field:SerializedName("groenendael")
	val groenendael: List<Any?>? = null,

	@field:SerializedName("hound")
	val hound: List<String?>? = null,

	@field:SerializedName("labradoodle")
	val labradoodle: List<Any?>? = null,

	@field:SerializedName("terrier")
	val terrier: List<String?>? = null,

	@field:SerializedName("maltese")
	val maltese: List<Any?>? = null,

	@field:SerializedName("bullterrier")
	val bullterrier: List<String?>? = null,

	@field:SerializedName("finnish")
	val finnish: List<String?>? = null,

	@field:SerializedName("african")
	val african: List<Any?>? = null,

	@field:SerializedName("newfoundland")
	val newfoundland: List<Any?>? = null,

	@field:SerializedName("shiba")
	val shiba: List<Any?>? = null,

	@field:SerializedName("pomeranian")
	val pomeranian: List<Any?>? = null,

	@field:SerializedName("pinscher")
	val pinscher: List<String?>? = null,

	@field:SerializedName("setter")
	val setter: List<String?>? = null,

	@field:SerializedName("frise")
	val frise: List<String?>? = null,

	@field:SerializedName("vizsla")
	val vizsla: List<Any?>? = null,

	@field:SerializedName("wolfhound")
	val wolfhound: List<String?>? = null,

	@field:SerializedName("dalmatian")
	val dalmatian: List<Any?>? = null,

	@field:SerializedName("doberman")
	val doberman: List<Any?>? = null
)
