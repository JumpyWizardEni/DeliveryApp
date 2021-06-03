package com.jumpywiz.delivery.model



import com.google.gson.annotations.SerializedName


data class Hints (

   @SerializedName("food") var food : Food,
   @SerializedName("measures") var measures : List<Measures>

)