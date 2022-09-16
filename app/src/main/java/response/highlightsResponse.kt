package response

import com.google.gson.annotations.SerializedName
import model.highlightItemModel

data class highlightsResponse(
    @SerializedName("content")
    val content: List<highlightItemModel>?,

    )
