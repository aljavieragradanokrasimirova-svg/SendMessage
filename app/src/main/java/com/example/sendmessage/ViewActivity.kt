package com.example.sendmessage

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sendmessage.model.Message

/**
 * Pantalla de destino: muestra el mensaje y su remitente.
 *
 * Recupera el objeto [Message] identificado por [MainActivity.EXTRA_MESSAGE].
 * Si no existe, ambos textos quedan vacíos. El icono vectorial es decorativo.
 *
 * @see MainActivity
 * @see android.content.Intent.getSerializableExtra
 */
class ViewActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "SendMessage.View"
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
        setContentView(R.layout.activity_view)
        val textoRemitente = findViewById<TextView>(R.id.remitenteRecibido)
        val textoMensaje = findViewById<TextView>(R.id.mensajeRecibido)
        @Suppress("DEPRECATION")
        val mensaje = intent.getSerializableExtra(MainActivity.EXTRA_MESSAGE) as? Message
        textoRemitente.text = mensaje?.sender?.name?.let {
            getString(R.string.sender_display, it)
        } ?: ""
        textoMensaje.text = mensaje?.text ?: ""
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
