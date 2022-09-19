package api

import model.CategoryPredictorResponse
import model.DescriptionItemResponse
import model.HighlightsProductResponse
import model.ItemProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
//criando interfaces de acordo com o token (que expira a cada 6horas) do MELI

const val ACCESS_TOKEN: String =
    "APP_USR-7547585209417493-091908-9ce61bb8d6a9cb988ad783b350378a59-281034336"

//chamando dentro de cada GET as responses que puxam os itens descritos no postman

interface CategoryService {
    @Headers("Authorization: Bearer $ACCESS_TOKEN")
    @GET("sites/MLB/domain_discovery/search?limit=1")
    //parametros, que estao no postman que puxa o motorola
    // ele vai concatenar tudo isso para chamar os itens do postman

    //duvida, esse 1 ele ja esta definindo o 1 e nao colocou ele como parametro igual o q
    //daria para fazer isso de alguma forma? tentei um "q","limit"
    fun list(@Query("q") categoryPartName: String): Call<List<CategoryPredictorResponse>>


    @Headers("Authorization: Bearer $ACCESS_TOKEN")
    @GET("highlights/MLB/category/{category_id}")
    // a mesma coisa, mas com category_id
    fun highlightsItemList(@Path("category_id") categoryId: String): Call<HighlightsProductResponse>

    @Headers("Authorization: Bearer $ACCESS_TOKEN")
    @GET("items")
    // a mesma coisa, mas com items
    fun itemList(@Query("ids") ids: String): Call<List<ItemProductResponse>>

    @Headers("Authorization: Bearer $ACCESS_TOKEN")
    @GET("items/{product_id}/description")
    // a mesma coisa, mas com itemDescription
    fun itemDescription(@Path("product_id") productId: String): Call<DescriptionItemResponse>


}