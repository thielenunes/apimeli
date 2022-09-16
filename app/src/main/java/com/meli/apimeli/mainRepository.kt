package com.meli.apimeli

import android.util.Log
import response.categoryidResponse
import response.descriptionItemsResponse
import model.itemModel
import response.highlightsResponse


class mainRepository {

    private val service: IGetServices = RetrofitServices.createGetService()
    var isLoading: Boolean? = null

    suspend fun getCategory(search: String): List<itemModel> {
        isLoading = true
        var list: List<String>?
        var response: List<itemModel> = emptyList()
        try {
            service.fetchCategory(search)[0]
                    .let { it ->
                    list = getHighlights(it.category_id.toString()).content
                            ?.filter { it.type == "ITEM" }
                        ?.map { it.id }
                response = getCategoryId(list).map { it.body }
                isLoading = false
            }
        } catch (e: Exception) {
            Log.e("MainRepository", "getCategory() : $e")
            isLoading = false
        }
        return response
    }


    private suspend fun getHighlights(idCategory: String): highlightsResponse {
        var response: highlightsResponse = highlightsResponse(null)
        try {
            response = service.fetchHighlightsResponse(idCategory)
        } catch (e: Exception) {
            Log.e("MainRepository", "getHighlights() : $e")
        }
        return response
    }

    private suspend fun getCategoryId(items: List<String>?): List<categoryidResponse> {
        var response: List<categoryidResponse> = emptyList()
        try {
            response = service.fetchIdCategory(items?.joinToString()!!)
        } catch (e: Exception) {
            Log.e("MainRepository", "getCategoryId() : $e")
        }
        return response
    }

    suspend fun getDescriptionItem(id: String): descriptionItemsResponse {
        var response = descriptionItemsResponse(null)
        try {
            response = service.fetchDescriptionItem(id)
        } catch (e: Exception) {
            Log.e("MainRepository", "getDescriptionItem: $e")
        }
        return response
    }
}