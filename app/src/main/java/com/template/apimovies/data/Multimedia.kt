package com.example.example

import com.google.gson.annotations.SerializedName


data class Multimedia (

  @SerializedName("type"   ) var type   : String? = null,
  @SerializedName("src"    ) var src    : String? = null,
  @SerializedName("height" ) var height : Int?    = null,
  @SerializedName("width"  ) var width  : Int?    = null

)