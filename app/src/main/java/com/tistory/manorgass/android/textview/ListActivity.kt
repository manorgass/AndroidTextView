package com.tistory.manorgass.android.textview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list)
        val userBank = arrayListOf(
                User("황교안", "대한민국 서울특별시 종로구 명륜동 어딘가"),
                User("황교안", "대한민국 서울특별시 종로구 명륜동 어딘가"),
                User("황교안", "대한민국 서울특별시 종로구 명륜동 어딘가"),
                User("황교안", "대한민국 서울특별시 종로구 명륜동 어딘가")
        )

        listView.adapter = UserListAdapter(userBank)

        val layoutManager = LinearLayoutManager(this)
        val dividerDeco = DividerItemDecoration(this, layoutManager.orientation)

        listView.layoutManager = layoutManager
        listView.addItemDecoration(dividerDeco)
    }

    inner class UserListAdapter(val userBank: List<User>) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            return UserViewHolder(view)
        }

        override fun getItemCount(): Int = userBank.size


        override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
            holder.bindView(userBank[position], position)
        }

        inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imgThumbnail = itemView.findViewById<ImageView>(R.id.imgThumbnail)
            val tvName = itemView.findViewById<TextView>(R.id.tvUserName)
            val tvAddress = itemView.findViewById<TextView>(R.id.tvUserAddress)

            fun bindView(user: User, position: Int) {
                imgThumbnail.setImageResource(user.resId)
                tvName.text = user.name
                tvAddress.text = user.address
                when (position) {
                    0 -> {
                        tvAddress.ellipsize = TextUtils.TruncateAt.MARQUEE
                        tvAddress.marqueeRepeatLimit = -1
                        tvAddress.isSelected = true
                    }
                    1 -> tvAddress.ellipsize = TextUtils.TruncateAt.START
                    2 -> tvAddress.ellipsize = TextUtils.TruncateAt.MIDDLE
                    3 -> tvAddress.ellipsize = TextUtils.TruncateAt.END
                }
            }
        }
    }
}
