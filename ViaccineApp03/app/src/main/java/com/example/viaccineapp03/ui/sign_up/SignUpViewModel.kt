package com.example.viaccineapp03.ui.sign_up

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    val email = MutableLiveData<String>()
    val userId = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordAgain = MutableLiveData<String>()
    val userName  = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val address = MutableLiveData<String>()
}