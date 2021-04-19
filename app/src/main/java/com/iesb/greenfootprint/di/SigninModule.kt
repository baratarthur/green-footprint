package com.iesb.greenfootprint.di

import com.iesb.greenfootprint.interector.SigninInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SigninModule {
    @Provides
    fun getInteractor() = SigninInteractor()
}