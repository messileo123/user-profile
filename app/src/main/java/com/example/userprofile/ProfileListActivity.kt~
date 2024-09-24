package com.example.userprofile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userprofile.adapter.userProfileAdapter
import com.example.userprofile.viewModel.userProfileViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileListActivity : AppCompatActivity() {
    private lateinit var profileViewModel: userProfileViewModel
    private lateinit var userProfileAdapter: userProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile_list)

        profileViewModel = ViewModelProvider(this).get(userProfileViewModel::class.java)
        val recyclerView =
            findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.profileRecyclerView)
        userProfileAdapter = userProfileAdapter()
        recyclerView.adapter = userProfileAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        profileViewModel.getUserProfiles().observe(this, Observer {
            userProfileAdapter.submitList(it)
        })
        userProfileAdapter.setOnItemClickListener {
            val intent = Intent(this, SingelProfileActivity::class.java)
            intent.putExtra("userProfile", it)
            startActivity(intent)

        }
        userProfileAdapter.setOnEditClickListener {
            val intent = Intent(this, SingelProfileActivity::class.java)
            intent.putExtra("userProfile", it)
            startActivity(intent)
        }
        userProfileAdapter.setOnDeleteClickListener {
            profileViewModel.deleteuserProfiles(it)
        }
        findViewById<FloatingActionButton>(R.id.addProfileBtn).setOnClickListener {
            startActivity(Intent(this, AddProfileActivity::class.java))


        }
    }
}