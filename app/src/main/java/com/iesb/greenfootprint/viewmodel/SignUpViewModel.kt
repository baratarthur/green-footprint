package com.iesb.greenfootprint.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iesb.greenfootprint.domain.RegisterForm
import com.iesb.greenfootprint.domain.RegisterResult
import com.iesb.greenfootprint.interector.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor (
    app: Application,
    private val interactor: AuthInteractor
) : AndroidViewModel(app) {

    val result = MutableLiveData<RegisterResult>()

    fun registerUser(form: RegisterForm) {
        viewModelScope.launch {
            result.value = interactor.registerUser(form)
        }
    }

}