package com.example.a51_mobile_design.ui.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    val userId = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordAgain = MutableLiveData<String>()
    val userName = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val address = MutableLiveData<String>()
}