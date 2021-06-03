package com.jumpywiz.delivery.model


import com.google.gson.annotations.SerializedName

   
data class Measures (

   @SerializedName("uri") var uri : String,
   @SerializedName("label") var label : String,
   @SerializedName("weight") var weight : Double

)