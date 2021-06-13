package com.iesb.greenfootprint.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.iesb.greenfootprint.interector.SignUpInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SignupModule {

    @Provides
    fun provideFirebaseAuth() = Firebase.auth

    @Provides
    fun getInteractor() = SignUpInteractor()
}