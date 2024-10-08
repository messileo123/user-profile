package com.example.userprofile

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.userprofile.model.userProfile
import com.example.userprofile.viewModel.userProfileViewModel

class SingelProfileActivity : AppCompatActivity() {
    private lateinit var userprofile:userProfile
    private lateinit var nameTxt: TextView
    private lateinit var emailTxt: TextView
    private lateinit var dobTxt: TextView
    private lateinit var districtTxt: TextView
    private lateinit var mobileTxt: TextView
    private lateinit var updateBtn:ImageButton
    private lateinit var deleteBtn:ImageButton
    private lateinit var profileViewModel: userProfileViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singel_profile)

        profileViewModel = ViewModelProvider(this).get(userProfileViewModel::class.java)
        userprofile = intent.getSerializableExtra("userProfile") as userProfile

        nameTxt = findViewById(R.id.nameLabelTextView)
        emailTxt = findViewById(R.id.emailLabelTextView)
        dobTxt = findViewById(R.id.dobLabelTextView)
        districtTxt = findViewById(R.id.districtLabelTextView)
        mobileTxt = findViewById(R.id.mobileLabelTextView)




        populatedField()
    }

    private fun populatedField() {
        nameTxt.text = userprofile.name
        emailTxt.text = userprofile.email
        dobTxt.text = userprofile.dob
        districtTxt.text = userprofile.district
        mobileTxt.text = userprofile.mobile


    }
}