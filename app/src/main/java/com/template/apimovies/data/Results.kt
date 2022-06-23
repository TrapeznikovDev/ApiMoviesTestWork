package com.example.example

import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("display_title"    ) var displayTitle    : String?     = null,
  @SerializedName("mpaa_rating"      ) var mpaaRating      : String?     = null,
  @SerializedName("critics_pick"     ) var criticsPick     : Int?        = null,
  @SerializedName("byline"           ) var byline          : String?     = null,
  @SerializedName("headline"         ) var headline        : String?     = null,
  @SerializedName("summary_short"    ) var summaryShort    : String?     = null,
  @SerializedName("publication_date" ) var publicationDate : String?     = null,
  @SerializedName("opening_date"     ) var openingDate     : String?     = null,
  @SerializedName("date_updated"     ) var dateUpdated     : String?     = null,
  @SerializedName("link"             ) var link            : Link?       = Link(),
  @SerializedName("multimedia"       ) var multimedia      : Multimedia? = Multimedia()

)