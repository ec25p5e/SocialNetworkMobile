package com.ec25p5e.socialnetworkmobile.feature_auth.data.repository

import android.content.SharedPreferences
import com.ec25p5e.socialnetworkmobile.R
import com.ec25p5e.socialnetworkmobile.core.util.Resource
import com.ec25p5e.socialnetworkmobile.core.util.SimpleResource
import com.ec25p5e.socialnetworkmobile.core.util.UiText
import com.ec25p5e.socialnetworkmobile.feature_auth.data.remote.AuthApi
import com.ec25p5e.socialnetworkmobile.feature_auth.data.remote.request.CreateAccountRequest
import com.ec25p5e.socialnetworkmobile.feature_auth.domain.repository.AuthRepository
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val sharedPreferences: SharedPreferences
) : AuthRepository {

    override suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource {
        val request = CreateAccountRequest(email, username, password)

        return try {
            val response = api.register(request)

            if (response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun login(email: String, password: String): SimpleResource {
        TODO("Not yet implemented")
    }

    override suspend fun authenticate(): SimpleResource {
        TODO("Not yet implemented")
    }
}