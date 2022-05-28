package com.ec25p5e.socialnetworkmobile.feature_auth.domain.models

import com.ec25p5e.socialnetworkmobile.core.util.SimpleResource
import com.ec25p5e.socialnetworkmobile.feature_auth.presentation.util.AuthError

data class LoginResult(
    val emailError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)