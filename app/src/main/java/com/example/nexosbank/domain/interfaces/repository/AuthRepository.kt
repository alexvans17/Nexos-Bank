package com.example.nexosbank.domain.interfaces.repository

import com.example.nexosbank.data.model.LoggedInUser
import com.example.nexosbank.domain.interfaces.interactor.AuthInteractor

interface AuthRepository {
    fun setInteractor(interactor: AuthInteractor)
    fun login(username: String, password: String)
    fun successLogin(fakeUser: LoggedInUser)
    fun failLogin(message: String)
    fun logout()
}