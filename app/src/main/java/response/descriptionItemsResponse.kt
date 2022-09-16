package response

import com.google.gson.annotations.SerializedName

data class descriptionItemsResponse(
    @SerializedName("plain_text")
    val plain_text: String?
)
