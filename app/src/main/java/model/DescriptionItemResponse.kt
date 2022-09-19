package model

import com.google.gson.annotations.SerializedName
//Puxando a descricao dos items da lista dentro do body
class DescriptionItemResponse {

    @SerializedName("plain_text")
    var item_description: String = ""


}