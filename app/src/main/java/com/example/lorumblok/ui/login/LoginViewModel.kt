package com.example.lorumblok.ui.login

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lorumblok.database.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository= UserRepository()):ViewModel() {
    var isLoginSuccess = mutableStateOf(false)
    var isFieldValid = mutableStateOf(true)

    fun validateUser(username:String,password: String,context: Context){
        viewModelScope.launch {
            if(userRepository.validateUser(username,password,context)){
                isLoginSuccess.value=true
            }else{
                isFieldValid.value=false
            }
        }
    }

}