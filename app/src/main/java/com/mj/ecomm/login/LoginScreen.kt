package com.mj.ecomm.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mj.ecomm.R
import com.mj.ecomm.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {

    lateinit var activityLoginScreenBinding: ActivityLoginScreenBinding
    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        activityLoginScreenBinding = DataBindingUtil.setContentView(this,R.layout.activity_login_screen)
       viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        activityLoginScreenBinding.lifecycleOwner = this
        activityLoginScreenBinding.viewmodel = viewModel

        viewModel._userMobileNumber.observe(this, Observer {
            println(it)
        })
        viewModel._userpassword.observe(this, Observer {
            println(it)
        })

    }
}