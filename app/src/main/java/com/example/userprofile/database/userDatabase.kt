package com.example.userprofile.database

import android.R.attr.name
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userprofile.dao.userProfileDao
import com.example.userprofile.model.userProfile
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import java.util.jar.Attributes.Name

@Database(entities = [userProfile::class],version = 1)

abstract class userDatabase: RoomDatabase()  {
    abstract fun userProfileDao(): userProfileDao
     companion object{
         @Volatile
         private var INSTANCE: userDatabase?=null
          @OptIn(InternalCoroutinesApi::class)
          fun getDatabase(context: Context): userDatabase{
              return INSTANCE?:synchronized(this){
                  val instance= Room.databaseBuilder( context.applicationContext, userDatabase::class.java,"user_database").build()
                   INSTANCE=instance
                  instance
              }




              }
          }
     }

