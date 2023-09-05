package com.example.lorumblok.ui.registration

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lorumblok.database.User
import com.example.lorumblok.database.UserRepository
import kotlinx.coroutines.launch

class RegistrationViewModel(private val userRepository: UserRepository= UserRepository()):ViewModel() {

    private var _isUserNameUnique = mutableStateOf(false)
    var isLoginError= mutableStateOf(false)
    val shouldNavigate = mutableStateOf(true)

    /*fun isUsernameValid(username: String,context: Context){
        viewModelScope.launch {
            _isUserNameUnique.value = !userRepository.validateUserName(username, context)
        }
    }*/


    fun insertUser(name:String,username:String,password:String,context: Context){
        viewModelScope.launch {
            _isUserNameUnique.value = !userRepository.validateUserName(username, context)
            if (password.isNotBlank() && name.isNotBlank() && _isUserNameUnique.value){
                userRepository.insertUser(User(username,password,name), context)
            }else{
                shouldNavigate.value=false
                isLoginError.value=true
            }
        }
    }
}