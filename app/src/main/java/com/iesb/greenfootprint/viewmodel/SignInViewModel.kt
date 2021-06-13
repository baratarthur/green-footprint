package com.iesb.greenfootprint.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iesb.greenfootprint.domain.LoginForm
import com.iesb.greenfootprint.domain.LoginResult
import com.iesb.greenfootprint.interector.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor (
    app: Application,
    val interactor: AuthInteractor
): AndroidViewModel(app) {
    val result = MutableLiveData<LoginResult>()

    fun login (form: LoginForm) {
        viewModelScope.launch {
            result.value = interactor.login(form)
        }
    }
}