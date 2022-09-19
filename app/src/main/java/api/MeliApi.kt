package api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//instanciando a api do MELI  usando retrofit igual o moco da udemy
class MeliApi {

    companion object {
        //pra não criar várias instâncias, criamos um Singleton, estilo de design de projeto que
        //so pode instanciar uma unica instancia, que pode ser usada em outros lugares

        //
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://api.mercadolibre.com/"

        //sempre vai retornar essa variavel, nunca vai reotnar um new retrofit
        private fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            INSTANCE = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(http.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return INSTANCE
        }

        fun createCategoryService(): CategoryService {
            return getRetrofitInstance().create(CategoryService::class.java)
        }
    }

}