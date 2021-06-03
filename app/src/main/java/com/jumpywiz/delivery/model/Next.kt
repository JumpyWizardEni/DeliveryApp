package com.jumpywiz.delivery.model

import com.google.gson.annotations.SerializedName

   
data class Next (

   @SerializedName("title") var title : String,
   @SerializedName("href") var href : String

)