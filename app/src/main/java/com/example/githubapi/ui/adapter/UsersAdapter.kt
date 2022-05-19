package com.example.githubapi.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubapi.R
import com.example.githubapi.ui.view.DetalhesActivity
import com.example.githubapi.ui.vo.UserVO


class UsersAdapter(private val users: List<UserVO>) :
    RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.users_list_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = users.size

     inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvIdentifier: TextView = itemView.findViewById(R.id.tv_id)
        private val tvLink: TextView = itemView.findViewById(R.id.tv_link)
        private val mImageview : ImageView = itemView.findViewById(R.id.mImageview)

        init{
            itemView.setOnClickListener{
                var pos = adapterPosition
                if( pos != RecyclerView.NO_POSITION){
                    val intent = Intent(itemView.context, DetalhesActivity::class.java)
                    intent.putExtra("name", users[pos].name)
                    intent.putExtra("link", users[pos].link)
                    intent.putExtra("avatar_url", users[pos].avatar_url)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    itemView.context.startActivity(intent)
                }
            }
        }
        fun bind(user: UserVO) {
            tvName.text = user.name
            tvIdentifier.text = user.identifier.toString()
            tvLink.text = user.link

            Glide.with(itemView.context)
                .load(user.avatar_url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(mImageview)
        }
    }
}