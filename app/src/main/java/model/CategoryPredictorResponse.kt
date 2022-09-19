package model

import com.google.gson.annotations.SerializedName
//puxando do postman o Preditor de Categoria
class CategoryPredictorResponse {

    @SerializedName("domain_id")
    var domain_id: String = ""

    @SerializedName("category_id")
    var category_id: String = ""

    @SerializedName("category_name")
    var category_name: String = ""


}