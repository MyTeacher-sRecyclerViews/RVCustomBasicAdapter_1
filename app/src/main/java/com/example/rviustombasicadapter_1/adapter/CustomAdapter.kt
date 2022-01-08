package com.example.rviustombasicadapter_1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rviustombasicadapter_1.R
import com.example.rviustombasicadapter_1.model.Member

class CustomAdapter(var context: Context, val members: List<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]
        if (holder is CustomViewHolder) {
            holder.firstName.text = member.firstName
            holder.lastName.text = member.lastName
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName = itemView.findViewById<TextView>(R.id.text_name)
        val lastName = itemView.findViewById<TextView>(R.id.text_count)
    }
}