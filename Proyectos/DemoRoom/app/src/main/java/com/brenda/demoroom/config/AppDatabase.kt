package com.brenda.demoroom.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brenda.demoroom.dao.UserDao
import com.brenda.demoroom.models.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao():UserDao
}