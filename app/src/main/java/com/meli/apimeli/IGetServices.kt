package com.meli.apimeli

import response.categoryidResponse
import response.categoryResponse
import response.descriptionItemsResponse
import response.highlightsResponse

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IGetServices {

    @GET("sites/MLB/domain_discovery/search?limit=1")
    suspend fun fetchCategory(@Query("q") search : String) : List<categoryResponse>

    @GET("highlights/MLB/category/{id}")
    suspend fun fetchHighlightsResponse(@Path("id") idCategory : String) : highlightsResponse

    @GET("items")
    suspend fun fetchIdCategory(@Query("ids") items : String) : List<categoryidResponse>

    @GET("items/{id}/description")
    suspend fun fetchDescriptionItem(@Path("id") itemId: String) : descriptionItemsResponse
}