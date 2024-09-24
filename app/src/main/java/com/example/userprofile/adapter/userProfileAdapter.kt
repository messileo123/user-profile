package com.example.userprofile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofile.R
import com.example.userprofile.model.userProfile

class userProfileAdapter():ListAdapter<userProfile,userProfileAdapter.userProfileViewHolder>(DiffCallback()) {

    private  var onItemClickListener: ((userProfile) -> Unit)? = null
    private var onDeleteClickListener: ((userProfile) -> Unit)? = null
    private var onEditClickListener: ((userProfile) -> Unit)? = null
    fun setOnItemClickListener(listener: (userProfile) -> Unit) {
        onItemClickListener = listener
    }
    fun setOnDeleteClickListener(listener: (userProfile) -> Unit) {
        onDeleteClickListener = listener
    }
    fun setOnEditClickListener(listener: (userProfile) -> Unit) {
        onEditClickListener = listener
    }
    inner class userProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val profilename: TextView = itemView.findViewById(R.id.userNameTxt)
        private val profileEmail: TextView = itemView.findViewById(R.id.userEmailTxt)
        private val profileDoB: TextView = itemView.findViewById(R.id.userDOBTxt)
        private val profileDistrict: TextView = itemView.findViewById(R.id.userDistritTxt)
        private val profileMobile: TextView = itemView.findViewById(R.id.userMobileTxt)
        private val updateBtn: ImageButton = itemView.findViewById(R.id.editBtn)
        private val deleteBtn:ImageButton = itemView.findViewById(R.id.deleteBtn)

        init {
            itemView.setOnClickListener {
                val position=adapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    val profile=getItem(position)
                  onItemClickListener?.invoke(profile)
                }
            }
            deleteBtn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onDeleteClickListener?.invoke(profile)

                }
            }
            updateBtn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onEditClickListener?.invoke(profile)

                }
            }



        }

        fun bind(userProfile: userProfile) {
            profilename.text = userProfile.name
            profileEmail.text = userProfile.email
            profileDoB.text = userProfile.dob
            profileDistrict.text = userProfile.district
            profileMobile.text = userProfile.mobile
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): userProfileAdapter.userProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.profile_list_layout, parent, false)

        return userProfileViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: userProfileAdapter.userProfileViewHolder, position: Int) {
      holder.bind(getItem(position))
    }

}

class DiffCallback : DiffUtil.ItemCallback<userProfile>() {
    override fun areItemsTheSame(oldItem: userProfile, newItem: userProfile): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: userProfile, newItem: userProfile): Boolean {
        return oldItem == newItem
    }
}