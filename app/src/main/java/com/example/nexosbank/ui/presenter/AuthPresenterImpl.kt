package com.example.nexosbank.ui.presenter

import com.example.nexosbank.data.model.LoggedInUser
import com.example.nexosbank.domain.interfaces.interactor.AuthInteractor
import com.example.nexosbank.ui.interfaces.presenter.AuthPresenter
import com.example.nexosbank.ui.interfaces.view.AuthView

class AuthPresenterImpl(private val authInteractor: AuthInteractor):
    AuthPresenter {

    init {
        authInteractor.setPresenter(this)
    }

    private var authView: AuthView? = null

    override fun setView(view: AuthView) {
        this.authView = view
    }

    override fun login(username: String, password: String) {
        authInteractor.login(username, password)
    }

    override fun successLogin(fakeUser: LoggedInUser) {
        authView?.successLogin(fakeUser)
    }

    override fun failLogin(message: String) {
        authView?.failLogin(message)
    }

    override fun logout() {
        authInteractor.logout()
    }
}