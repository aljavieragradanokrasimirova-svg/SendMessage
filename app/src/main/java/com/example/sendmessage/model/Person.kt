package com.example.sendmessage.model

import java.io.Serializable

/**
 * Representa al **remitente** de un [Message].
 *
 * Implementa [Serializable] para viajar junto al mensaje entre actividades.
 *
 * @property name Nombre del remitente escrito por el usuario.
 */
data class Person(val name: String) : Serializable
