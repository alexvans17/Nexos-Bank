package com.example.nexosbank.data.repository

import com.example.nexosbank.data.interfaces.ApiAuth
import com.example.nexosbank.data.model.LoggedInUser
import com.example.nexosbank.domain.interfaces.interactor.AuthInteractor
import com.example.nexosbank.domain.interfaces.repository.AuthRepository


class AuthRepositoryImpl(private val apiAuth: ApiAuth):
    AuthRepository {

    init {
        apiAuth.setRepository(this)
    }

    private lateinit var interactor: AuthInteractor

    override fun setInteractor(interactor: AuthInteractor) {
        this.interactor = interactor
    }

    override fun login(username: String, password: String) {
        apiAuth.login(username, password)
    }

    override fun successLogin(fakeUser: LoggedInUser) {
        interactor.successLogin(fakeUser)
    }

    override fun failLogin(message: String) {
        interactor.failLogin(message)
    }

    override fun logout() {
        apiAuth.logout()
    }
}