package com.jumpywiz.delivery.model

import com.google.gson.annotations.SerializedName

   
data class Nutrients (

   @SerializedName("ENERC_KCAL") var ENERCKCAL : Double,
   @SerializedName("PROCNT") var PROCNT : Double,
   @SerializedName("FAT") var FAT : Double,
   @SerializedName("CHOCDF") var CHOCDF : Double,
   @SerializedName("FIBTG") var FIBTG : Double

)