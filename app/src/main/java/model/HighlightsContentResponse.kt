package model

import com.google.gson.annotations.SerializedName
//puxando a o que ta dentro do content, que ta dentro do top 20 categoria
class HighlightsContentResponse {

    @SerializedName("id")
    var product_id: String = ""

    @SerializedName("position")
    var position: Int = 0

    @SerializedName("type")
    var type: String = "ITEM"


}