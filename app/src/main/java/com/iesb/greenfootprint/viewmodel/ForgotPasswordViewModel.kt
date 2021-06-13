package com.iesb.greenfootprint.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iesb.greenfootprint.domain.ForgotPasswordForm
import com.iesb.greenfootprint.domain.ForgotPasswordResult
import com.iesb.greenfootprint.interector.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel  @Inject constructor (
    app: Application,
    val interactor: AuthInteractor
): AndroidViewModel(app) {
    val result = MutableLiveData<ForgotPasswordResult>()

    fun requestPassword(form: ForgotPasswordForm) {
        viewModelScope.launch {
            result.value = interactor.requestPassword(form)
        }
    }
}