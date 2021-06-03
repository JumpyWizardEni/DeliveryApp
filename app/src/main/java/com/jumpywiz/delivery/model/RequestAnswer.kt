package com.jumpywiz.delivery.model


import com.google.gson.annotations.SerializedName


data class RequestAnswer (

   @SerializedName("text") var text : String,
   @SerializedName("parsed") var parsed : List<Parsed>,
   @SerializedName("hints") var hints : List<Hints>,
   @SerializedName("_links") var Links : Links

)