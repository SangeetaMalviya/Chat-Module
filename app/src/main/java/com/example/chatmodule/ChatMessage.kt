package com.example.chatmodule

data class ChatMessage(
    val content: String,
    val isFile: Boolean,
    val isSent: Boolean
)

