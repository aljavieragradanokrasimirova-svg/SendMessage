package com.example.sendmessage.model

import java.io.Serializable

/**
 * Representa un **mensaje** y su remitente, que viajan juntos entre actividades.
 *
 * Implementa [Serializable] para enviarse como un dato extra de un Intent.
 * El remitente [Person] también es serializable.
 *
 * @property text Texto del mensaje escrito por el usuario.
 * @property sender Persona que envía el mensaje.
 */
data class Message(val text: String, val sender: Person) : Serializable
