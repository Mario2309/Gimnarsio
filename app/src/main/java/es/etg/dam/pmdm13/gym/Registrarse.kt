package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.etg.dam.pmdm13.gym.MainActivity.Companion.EXTRA_USUARIO
import es.etg.dam.pmdm13.gym.preferencias.GuardarPreferencia

class Registrarse : AppCompatActivity() {

    companion object{
        //Constante para el paso de extras
        const val EXTRA_USUARIO = "MainActivity:Usuario"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registrarse)

        val volverMain = Intent(this, MainActivity::class.java)
        val btnRegistrar:Button = findViewById(R.id.btnRegistrar)
        val btnFlecha:ImageButton = findViewById(R.id.flechaVolver)
        val text = "Error 404!! Not Fount!!"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(this, text, duration)
        val btnChrome:ImageButton = findViewById(R.id.imageButtonChrome)
        val btnFacebook:ImageButton = findViewById(R.id.imageButtonFacebook)

        btnChrome.setOnClickListener {
            toast.show()
        }

        btnFacebook.setOnClickListener {
            toast.show()
        }

        btnFlecha.setOnClickListener {
            startActivity(volverMain)
        }

        btnRegistrar.setOnClickListener {
            startActivity(volverMain)
            enviarInfo()

        }


    }
    

    private fun enviarInfo() {
        val textoCorreo = findViewById<EditText>(R.id.editTextCorreo).text
        val textoUsuario = findViewById<EditText>(R.id.editTextUsuarioNuevo).text
        val textoContrasenia = findViewById<EditText>(R.id.editTextContraseña).text

        val intent = Intent(this, MainActivity::class.java)
        val usuario = Usuario(textoCorreo.toString(), textoUsuario.toString(), textoContrasenia.toString())

        val guardarPreferencia = GuardarPreferencia(this)
        guardarPreferencia.guardar(textoUsuario.toString())

        intent.putExtra(EXTRA_USUARIO, usuario)
        startActivity(intent)

    }
}