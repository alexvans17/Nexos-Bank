package com.example.nexosbank.data.datasource.cloud

import com.example.nexosbank.data.interfaces.ApiAuth
import com.example.nexosbank.data.model.LoggedInUser
import com.example.nexosbank.domain.interfaces.repository.AuthRepository

class ApiAuthImpl: ApiAuth {

    private lateinit var repository: AuthRepository

    override fun setRepository(repository: AuthRepository) {
        this.repository = repository
    }

    override fun login(username: String, password: String) {
        try {
            if (username=="admin" && password=="12345"){
                val fakeUser = LoggedInUser(
                    java.util.UUID.randomUUID().toString(),
                    "Jane Doe", "+9999999", "janedoe@admin.com")
                repository.successLogin(fakeUser)
            }else
                repository.failLogin("Invalid user")

        } catch (e: Throwable) {
            repository.failLogin(e.toString())
        }
    }

    override fun logout() {
        // TODO: revoke authentication
    }
}