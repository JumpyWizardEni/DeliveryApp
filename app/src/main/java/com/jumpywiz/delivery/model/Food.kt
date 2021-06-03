package com.jumpywiz.delivery.model



import com.google.gson.annotations.SerializedName


data class Food (

    @SerializedName("foodId") var foodId : String,
    @SerializedName("label") var label : String,
    @SerializedName("nutrients") var nutrients : Nutrients,
    @SerializedName("brand") var brand: String,
    @SerializedName("category") var category : String,
    @SerializedName("categoryLabel") var categoryLabel : String,
    @SerializedName("image") var image : String,
    @SerializedName("servingsPerContainer") var servingsPerContainer : Double

)