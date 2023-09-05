package com.example.lorumblok.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Query("Select exists (Select * from user where username like :userName and password like :password)")
    suspend fun validateUser(userName:String, password:String):Boolean

    @Query("Select exists (Select * from user where username like :userName)")
    suspend fun validateUsername(userName: String):Boolean
}