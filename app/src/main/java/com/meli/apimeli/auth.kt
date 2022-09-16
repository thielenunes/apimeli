package response

import okhttp3.Interceptor
import okhttp3.Response


class Auth : Interceptor {

    private val accessToken = "Bearer APP_USR-7547585209417493-091513-d87755ac32a9308a514b0e894b0e0f2d-281034336"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", accessToken)
            .build()
        return chain.proceed(request)
    }
}