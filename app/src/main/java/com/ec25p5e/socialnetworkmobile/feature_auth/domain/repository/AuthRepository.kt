package com.ec25p5e.socialnetworkmobile.feature_auth.domain.repository

import com.ec25p5e.socialnetworkmobile.core.util.SimpleResource

interface AuthRepository {

    suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource

    suspend fun login(
        email: String,
        password: String
    ): SimpleResource

    suspend fun authenticate(): SimpleResource
}