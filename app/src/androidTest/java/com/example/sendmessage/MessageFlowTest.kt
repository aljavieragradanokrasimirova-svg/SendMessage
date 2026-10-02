package com.example.sendmessage

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Verifica en un dispositivo o emulador el paso de mensaje y remitente.
 *
 * Estas pruebas son una comprobación adicional del ejercicio, no lógica de la aplicación.
 * @see MainActivity
 * @see ViewActivity
 */
@RunWith(AndroidJUnit4::class)
class MessageFlowTest {
    /** Comprueba el envío de ambos datos, la imagen y el regreso a la entrada. */
    @Test
    fun enviarMensajeYVolver() {
        ActivityScenario.launch(MainActivity::class.java).use {
            val mensaje = "Hola, Javi: mañana seguimos. ¡Ánimo!"
            val remitente = "Lucía"
            onView(withId(R.id.senderName)).perform(replaceText(remitente), closeSoftKeyboard())
            onView(withId(R.id.userMessage)).perform(replaceText(mensaje), closeSoftKeyboard())
            onView(withId(R.id.sendMsgButton)).perform(click())
            onView(withId(R.id.remitenteRecibido)).check(matches(withText("De: $remitente")))
            onView(withId(R.id.mensajeRecibido)).check(matches(withText(mensaje)))
            onView(withId(R.id.imageView)).check(matches(isDisplayed()))
            pressBack()
            onView(withId(R.id.senderName)).check(matches(withText(remitente)))
            onView(withId(R.id.userMessage)).check(matches(withText(mensaje)))
            onView(withId(R.id.sendMsgButton)).check(matches(isDisplayed()))
        }
    }

    /** Comprueba que un mensaje vacío abre la segunda pantalla sin provocar un error. */
    @Test
    fun enviarMensajeVacio() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withId(R.id.senderName)).perform(replaceText(""), closeSoftKeyboard())
            onView(withId(R.id.userMessage)).perform(replaceText(""), closeSoftKeyboard())
            onView(withId(R.id.sendMsgButton)).perform(click())
            onView(withId(R.id.remitenteRecibido)).check(matches(withText("De: ")))
            onView(withId(R.id.mensajeRecibido)).check(matches(withText("")))
            onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        }
    }
}
