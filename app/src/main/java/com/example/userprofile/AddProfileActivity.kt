package com.example.userprofile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.userprofile.model.userProfile
import com.example.userprofile.viewModel.userProfileViewModel

class AddProfileActivity : AppCompatActivity() {
    private lateinit var profileViewModel: userProfileViewModel
    private lateinit var nameTxt:EditText
    private lateinit var email:EditText
    private lateinit var dobTxt:EditText
    private lateinit var districtTxt:EditText
    private lateinit var mobileTxt:EditText
    private lateinit var saveButton:Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_profile)
        profileViewModel= ViewModelProvider(this).get(userProfileViewModel::class.java)

        nameTxt = findViewById(R.id.profileNameEt)
        email = findViewById(R.id.profileEmailEt)
        dobTxt = findViewById(R.id.profileDOBEt)
        districtTxt = findViewById(R.id.profileDistrictEt)
        mobileTxt = findViewById(R.id.profilemobileEt)
        saveButton = findViewById(R.id.addBtn)
        saveButton.setOnClickListener {
            val name = nameTxt.text.toString().trim()
            val email = email.text.toString().trim()
            val dob = dobTxt.text.toString().trim()
            val district = districtTxt.text.toString().trim()
            val mobile = mobileTxt.text.toString().trim()
            val userProfile = userProfile(0, name=name, email=email, dob=dob, district=district, mobile=mobile)
            profileViewModel.insertuserProfiles(userProfile)
            finish()
        }


    }
}