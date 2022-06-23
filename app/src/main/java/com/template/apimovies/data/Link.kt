package com.example.example

import com.google.gson.annotations.SerializedName


data class Link (

  @SerializedName("type"                ) var type              : String? = null,
  @SerializedName("url"                 ) var url               : String? = null,
  @SerializedName("suggested_link_text" ) var suggestedLinkText : String? = null

)