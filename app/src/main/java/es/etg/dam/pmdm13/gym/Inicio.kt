package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.etg.dam.pmdm13.gym.preferencias.LeerPreferencia

@Suppress("DEPRECATION")
class Inicio : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_inicio)

        val botonDesLogg:ImageButton = findViewById(R.id.imageButtonUnlogg)
        val volverLogin = Intent(this, MainActivity::class.java)
        val botonPerfil:ImageButton = findViewById(R.id.imageButtonUser)
        val mensaje = "Error!!"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(this, mensaje,duration)
        val botonAbrir:Button = findViewById(R.id.btmTorno)
        val botonEjercicio:Button = findViewById(R.id.btmSelecEjer)

        actualizarSaludo()

        botonDesLogg.setOnClickListener {
            startActivity(volverLogin)
        }

        botonEjercicio.setOnClickListener{
            toast.show()
        }

        botonAbrir.setOnClickListener {
            toast.show()
        }

        botonPerfil.setOnClickListener {
            toast.show()
        }


    }

    private fun actualizarSaludo() {
        val leerPreferencia = LeerPreferencia(this)
        val nombre = leerPreferencia.leer()

        if (nombre != null) {
            val textoNombre = findViewById<TextView>(R.id.textViewNomUsu).setText((nombre))
        }
    }

    private fun mostrarNombreUsuario() {
        val usuario = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(MainActivity.EXTRA_USUARIO, Usuario::class.java)
        } else {
            intent.getParcelableExtra<Usuario>(MainActivity.EXTRA_USUARIO)
        }
        val toat = Toast.makeText(this, usuario.toString(), Toast.LENGTH_LONG)
        toat.show()
    }
}