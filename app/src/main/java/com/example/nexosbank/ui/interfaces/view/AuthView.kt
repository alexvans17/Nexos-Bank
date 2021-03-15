package com.example.nexosbank.ui.interfaces.view

import com.example.nexosbank.data.model.LoggedInUser

interface AuthView {
    fun login(username : String, password: String )
    fun successLogin(fakeUser: LoggedInUser)
    fun failLogin(message: String)
}
