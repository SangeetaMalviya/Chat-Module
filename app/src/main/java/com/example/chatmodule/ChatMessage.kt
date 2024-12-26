package com.example.chatmodule

data class ChatMessage(
    val text: String? = null,
    val fileUri: String? = null,
    val isSentByUser: Boolean = false
)

