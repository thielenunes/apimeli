package model

import com.google.gson.annotations.SerializedName
//puxando em detalhes alguns pontos especificos dentro do body do multiget para montar
// o detalhamento do produto
class MultigetProductResponse {

    @SerializedName("id")
    var item_id: String = ""

    @SerializedName("title")
    var item_title: String = ""

    @SerializedName("price")
    var item_price: Float = 0.0F

    @SerializedName("secure_thumbnail")
    var item_thumbnail: String = ""


}