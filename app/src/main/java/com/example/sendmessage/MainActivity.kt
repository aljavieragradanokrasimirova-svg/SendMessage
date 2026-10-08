package com.example.sendmessage

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import com.example.sendmessage.model.Message
import com.example.sendmessage.model.Person

/**
 * Pantalla de entrada: permite escribir un mensaje y abrir [ViewActivity].
 *
 * El texto y el remitente se recogen al pulsar el botón y se envían juntos en
 * un [Message] serializable. No se envían por Internet.
 *
 * @see ViewActivity
 * @see android.content.Intent
 * @author Javi
 * @version 1.0
 */
class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "SendMessage.Main"
        /** Clave compartida por ambas pantallas para identificar el objeto Message. */
        const val EXTRA_MESSAGE = "mensaje"
    }

    //region Ciclo de vida
    /**
     * Inicializa el diseño, sus componentes y el registro del ciclo de vida.
     *
     * @param savedInstanceState Estado anterior proporcionado por Android; puede ser nulo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val campoRemitente = findViewById<EditText>(R.id.senderName)
        val campoMensaje = findViewById<EditText>(R.id.userMessage)
        val campoBoton = findViewById<Button>(R.id.sendMsgButton)
        campoBoton.setOnClickListener {
            val mensaje = Message(
                text = campoMensaje.text.toString(),
                sender = Person(name = campoRemitente.text.toString())
            )
            val intent = Intent(this, ViewActivity::class.java)
            intent.putExtra(EXTRA_MESSAGE, mensaje)
            startActivity(intent)
        }
        val layoutPrincipal = findViewById<LinearLayout>(R.id.main)
        val paddingIzquierdo = layoutPrincipal.paddingLeft
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    /** Registra que la actividad pasa a ser visible. */
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    /** Registra que la actividad está en primer plano y puede recibir interacción. */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    /** Registra que la actividad pierde el primer plano; no implica su destrucción. */
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    /** Registra que la actividad deja de ser visible. */
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    /** Registra el regreso de una actividad que estaba detenida. */
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    /** Registra la destrucción de esta instancia; Android no garantiza esta llamada al matar el proceso. */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
    //endregion
}
