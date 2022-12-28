package com.mj.ecomm.login

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var userMobileNumber = MutableLiveData<String>()
    val _userMobileNumber: LiveData<String> get() = userMobileNumber
    var userPassword = MutableLiveData<String>()
    val _userpassword: LiveData<String> = userPassword
    val error = MutableLiveData<String>()


    fun onSubmit(view: View) {

        if(_userMobileNumber.value.toString().length<10)
        {
          error.postValue("Please Enter valid MobileNumber")
        }


        Toast.makeText(
            view.context,
            "User Mobile Number:: ${userMobileNumber.value}",
            Toast.LENGTH_SHORT
        ).show()
    }


}