package com.example.chatmodule

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val chatMessages: List<ChatMessage>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val messageTextView: TextView = view.findViewById(R.id.messageTextView)
        val filePreview: ImageView = view.findViewById(R.id.filePreview)
        val fileName: TextView = view.findViewById(R.id.fileName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message = chatMessages[position]

        if (message.text != null) {
            holder.messageTextView.visibility = View.VISIBLE
            holder.messageTextView.text = message.text
        } else {
            holder.messageTextView.visibility = View.GONE
        }

        if (message.fileUri != null) {
            val uri = Uri.parse(message.fileUri)
            if (uri.toString().endsWith(".jpg") || uri.toString().endsWith(".png")) {
                holder.filePreview.visibility = View.VISIBLE
                holder.fileName.visibility = View.GONE
                holder.filePreview.setImageURI(uri)
            } else {
                holder.filePreview.visibility = View.GONE
                holder.fileName.visibility = View.VISIBLE
                holder.fileName.text = uri.lastPathSegment
            }
        } else {
            holder.filePreview.visibility = View.GONE
            holder.fileName.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = chatMessages.size
}
