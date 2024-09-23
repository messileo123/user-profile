package com.example.userprofile.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.userprofile.database.userDatabase
import com.example.userprofile.model.userProfile
import com.example.userprofile.repository.userProfileRepository

class userProfileViewModel(application: Application): AndroidViewModel(application) {

init {
    val userProfileDao= userDatabase.getDatabase(application).userProfileDao()
  repository = userProfileRepository(userProfileDao)

}
    fun getuserProfiles(): LiveData<List<userProfile>>{
        return repositry.getuserProfiles()
    }
    fun insert(userProfile: userProfile){
        return repository.insert(userProfile)
    }

}