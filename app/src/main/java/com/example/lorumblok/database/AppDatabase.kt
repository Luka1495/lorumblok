package com.example.lorumblok.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Game::class, User::class], version = 2)
abstract class AppDatabase:RoomDatabase() {
    abstract fun gameDao():GameDao
    abstract fun userDao():UserDao
    companion object{
        private var instance:AppDatabase?=null
        fun getDatabase(context: Context): AppDatabase {
            if(instance==null){
                instance=buildDatabase(context)
            }
            return instance!!
        }
        private fun buildDatabase(context: Context)= Room.databaseBuilder(
            context,
            AppDatabase::class.java, "GameDatabase"
        ).fallbackToDestructiveMigration().build()
    }
}