package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import es.etg.dam.pmdm13.gym.preferencias.GuardarPreferencia
import es.etg.dam.pmdm13.gym.preferencias.LeerPreferencia

class MainActivity : AppCompatActivity(){
    companion object{
        //Constante para el paso de extras
        const val EXTRA_USUARIO = "Inicio:user"
    }

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val leerPreferencia = LeerPreferencia(this)
        val nombre = leerPreferencia.leer()

        if (nombre != null){
            val textoNombre = findViewById<TextView>(R.id.editTextUsuario).setText((nombre))
        }

        val btnIniciarSesion:Button = findViewById(R.id.btnIniciar)
        val btnRegistrarse:Button = findViewById(R.id.btnRegistrar)
        val abrirInicio = Intent(this, Inicio::class.java)
        val abrirAct2 = Intent(this, Registrarse::class.java)

        btnRegistrarse.setOnClickListener{
            startActivity(abrirAct2)
        }

        btnIniciarSesion.setOnClickListener {
            startActivity(abrirInicio)
            val nombreUsuario = findViewById<TextView>(R.id.editTextUsuario).text.toString()
            val guardarPreferencia = GuardarPreferencia(this)
            guardarPreferencia.guardar(nombreUsuario)
        }

    }

}