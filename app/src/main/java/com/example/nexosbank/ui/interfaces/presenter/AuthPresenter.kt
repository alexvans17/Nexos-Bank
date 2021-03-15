package com.example.nexosbank.ui.interfaces.presenter

import com.example.nexosbank.data.model.LoggedInUser
import com.example.nexosbank.ui.interfaces.view.AuthView

interface AuthPresenter {
    fun setView(view: AuthView): Boolean
    fun login(username: String, password: String)
    fun successLogin(fakeUser: LoggedInUser)
    fun failLogin(message: String)
    fun logout()
}
