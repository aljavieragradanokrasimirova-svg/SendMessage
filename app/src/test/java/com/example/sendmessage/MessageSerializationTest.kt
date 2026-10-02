package com.example.sendmessage

import com.example.sendmessage.model.Message
import com.example.sendmessage.model.Person
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class MessageSerializationTest {
    @Test
    fun conservaElMensajeYElRemitente() {
        val original = Message("Buenas noches", Person("Javi"))
        val bytes = ByteArrayOutputStream().use { output ->
            ObjectOutputStream(output).use { it.writeObject(original) }
            output.toByteArray()
        }

        val restaurado = ObjectInputStream(ByteArrayInputStream(bytes)).use {
            it.readObject() as Message
        }

        assertEquals(original, restaurado)
    }
}
