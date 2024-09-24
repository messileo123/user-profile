package com.example.userprofile.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.userprofile.database.userDatabase
import com.example.userprofile.model.userProfile
import com.example.userprofile.repository.userProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class userProfileViewModel(application:Application):AndroidViewModel(application) {

    private val repository: userProfileRepository


    init {


        val userProfileDao = userDatabase.getDatabase(application).userProfileDao()
        repository = userProfileRepository(userProfileDao)
    }

     fun getUserProfiles(): LiveData<List<userProfile>> {
        return repository.getAllProfiles()
    }

    suspend fun insert(userProfile: userProfile) {

        return repository.insert(userProfile)
    }

    fun insertuserProfiles(userProfile: userProfile) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(userProfile)

        }
    }

    fun updateuserProfiles(userProfile: userProfile) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(userProfile)
        }
    }
    fun deleteuserProfiles(userProfile: userProfile) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(userProfile)
        }
    }
}


