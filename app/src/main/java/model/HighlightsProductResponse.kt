package model

import com.google.gson.annotations.SerializedName

class HighlightsProductResponse {

    @SerializedName("content")
    lateinit var content: List<HighlightsContentResponse>



}