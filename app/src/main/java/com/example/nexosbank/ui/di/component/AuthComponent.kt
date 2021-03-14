package com.example.nexosbank.ui.di.component

import com.example.nexosbank.ui.di.module.AuthModule
import com.example.nexosbank.ui.view.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AuthModule::class])
interface AuthComponent {
    fun inject(loginActivity: LoginActivity)
}