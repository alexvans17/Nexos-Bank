package com.example.nexosbank.ui.di.module

import com.example.nexosbank.data.datasource.cloud.ApiAuthImpl
import com.example.nexosbank.data.repository.AuthRepositoryImpl
import com.example.nexosbank.domain.interactor.AuthInteractorImpl
import com.example.nexosbank.ui.presenter.AuthPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthModule {

    @Provides
    @Singleton
    fun provideApiAuthImpl()= ApiAuthImpl()

    @Provides
    @Singleton
    fun provideAuthRepositoryImpl(
        apiAuthImpl: ApiAuthImpl
    ) = AuthRepositoryImpl(apiAuthImpl)

    @Provides
    @Singleton
    fun provideAuthInteractorImpl(
        authRepositoryImpl: AuthRepositoryImpl
    )= AuthInteractorImpl(authRepositoryImpl)

    @Provides
    @Singleton
    fun provideAuthPresenterImpl(
        authInteractorImpl: AuthInteractorImpl
    ) = AuthPresenterImpl(authInteractorImpl)
}