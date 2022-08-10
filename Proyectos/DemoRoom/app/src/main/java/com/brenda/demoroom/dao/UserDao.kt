package com.brenda.demoroom.dao

import androidx.room.*
import com.brenda.demoroom.models.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAll():List<User>

    @Query("SELECT * FROM User WHERE uid = :id")
    fun getUserById(id:Int):User

    @Insert
    fun insert(user: ArrayList<User>)

    @Update
    fun update(user:User)

    @Delete
    fun delete(user: User)
}