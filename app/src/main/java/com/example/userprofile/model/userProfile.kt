package com.example.userprofile.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName ="userProfile")
data class userProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
     val name: String="",
      val  email: String="",
    val dob: String="",
     val district: String="",
    val  mobile: String="",
): Serializable
