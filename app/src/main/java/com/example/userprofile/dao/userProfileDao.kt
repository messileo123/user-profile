package com.example.userprofile.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.userprofile.model.userProfile

@Dao

interface userProfileDao {
    @Insert
    suspend fun insert( userProfile: userProfile)
    @Update
    suspend fun update( userProfile: userProfile)
    @Delete
    suspend fun delete( userProfile: userProfile)
     @Query("SELECT * FROM userProfile")
     fun getAllProfiles(): LiveData<List<userProfile>>

}