package com.example.lorumblok.database

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class UserRepository {

    suspend fun validateUser(username:String, password:String, context:Context) = withContext(Dispatchers.IO){
        AppDatabase.getDatabase(context).userDao().validateUser(username,password)
    }

    suspend fun insertUser(user: User,context: Context){
        withContext(Dispatchers.IO){
            AppDatabase.getDatabase(context).userDao().insertUser(user)
        }
    }
    suspend fun validateUserName(username:String,context: Context)= withContext(Dispatchers.IO){
        AppDatabase.getDatabase(context).userDao().validateUsername(username)
    }
}