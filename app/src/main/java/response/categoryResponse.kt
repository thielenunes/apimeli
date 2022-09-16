package response

import com.google.gson.annotations.SerializedName

data class categoryResponse(
    @SerializedName("category_id")
    val category_id: String?,
)
