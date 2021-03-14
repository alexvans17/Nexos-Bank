package com.example.nexosbank.data.interfaces

import com.example.nexosbank.domain.interfaces.repository.AuthRepository

interface ApiAuth {
    fun setRepository(repository: AuthRepository)
    fun login(username: String, password: String)
    fun logout()
}