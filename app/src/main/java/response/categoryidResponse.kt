package response

import com.google.gson.annotations.SerializedName
import model.itemModel

data class categoryidResponse (
    @SerializedName("body")
    val body: itemModel
)