package com.example.userprofile.repository

import androidx.lifecycle.LiveData
import com.example.userprofile.dao.userProfileDao
import com.example.userprofile.model.userProfile

class userProfileRepository(private val  userProfileDao: userProfileDao) {
    fun getAllProfiles(): LiveData<List<userProfile>>{
    return userProfileDao.getAllProfiles()
    }
    suspend fun insert(userProfile: userProfile){
        return userProfileDao.insert(userProfile)

    }
    suspend fun update(userProfile: userProfile){
        return userProfileDao.update(userProfile)
    }
    suspend fun delete(userProfile: userProfile){
        return userProfileDao.delete(userProfile)

    }

}