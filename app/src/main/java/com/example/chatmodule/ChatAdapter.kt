package com.example.chatmodule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val messages: List<ChatMessage>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textMessage: TextView = view.findViewById(R.id.textMessage)
        val imagePreview: ImageView = view.findViewById(R.id.imagePreview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat_message, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message = messages[position]
        if (message.isFile) {
            holder.imagePreview.visibility = View.VISIBLE
            holder.textMessage.visibility = View.GONE
            // Load file preview (e.g., image) into imagePreview
        } else {
            holder.textMessage.visibility = View.VISIBLE
            holder.imagePreview.visibility = View.GONE
            holder.textMessage.text = message.content
        }
    }

    override fun getItemCount(): Int = messages.size
}
