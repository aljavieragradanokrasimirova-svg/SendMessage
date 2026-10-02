package com.example.sendmessage.model

import java.io.Serializable

/** Mensaje y remitente que viajan juntos en un Intent. */
data class Message(val text: String, val sender: Person) : Serializable
