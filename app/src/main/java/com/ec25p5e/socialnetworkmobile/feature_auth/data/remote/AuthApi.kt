package com.ec25p5e.socialnetworkmobile.feature_auth.data.remote

import com.ec25p5e.socialnetworkmobile.core.data.dto.response.BasicApiResponse
import com.ec25p5e.socialnetworkmobile.feature_auth.data.remote.request.CreateAccountRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/api/v1/user/create")
    suspend fun register(
        @Body request: CreateAccountRequest
    ): BasicApiResponse<Unit>

    companion object {
        const val BASE_URL = "http://127.0.0.1:8080/"
    }
}