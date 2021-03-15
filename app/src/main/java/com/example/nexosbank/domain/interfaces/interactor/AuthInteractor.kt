package com.example.nexosbank.domain.interfaces.interactor

import com.example.nexosbank.data.model.LoggedInUser
import com.example.nexosbank.ui.interfaces.presenter.AuthPresenter

interface AuthInteractor {
    fun setPresenter(presenter: AuthPresenter)
    fun login(username: String, password: String)
    fun successLogin(fakeUser: LoggedInUser)
    fun failLogin(message: String)
    fun logout()
}
