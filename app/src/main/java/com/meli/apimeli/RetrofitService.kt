package com.meli.apimeli

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import response.Auth

class RetrofitServices {

    companion object {

        private  val client = OkHttpClient.Builder().apply {
            addInterceptor(Auth())
        }.build()

        private  lateinit var  INSTANCE : Retrofit
        private const val BASE_URL = "https://api.mercadolibre.com/"

        private fun getRetrofitInstance() : Retrofit {
            if(!Companion::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return  INSTANCE
        }

        fun createGetService() : IGetServices {
            return getRetrofitInstance().create(IGetServices::class.java)
        }
    }
}