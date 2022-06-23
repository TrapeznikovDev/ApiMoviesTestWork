package com.template.apimovies.data

import com.google.gson.annotations.SerializedName


data class ExampleJson2KtKotlin (

  @SerializedName("status"      ) var status     : String?            = null,
  @SerializedName("copyright"   ) var copyright  : String?            = null,
  @SerializedName("has_more"    ) var hasMore    : Boolean?           = null,
  @SerializedName("num_results" ) var numResults : Int?               = null,
  @SerializedName("results"     ) var results    : ArrayList<Results> = arrayListOf()

)