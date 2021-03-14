package com.example.nexosbank.domain.entity

data class LoginResult(
        val success: LoggedInUserView? = null,
        val error: Int? = null
)