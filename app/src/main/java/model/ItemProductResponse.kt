package model

import com.google.gson.annotations.SerializedName
//puxando o body, de dentro do multiget
class ItemProductResponse {

    //Get details by item
    @SerializedName("body")
    lateinit var item: MultigetProductResponse


}