package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import es.etg.dam.pmdm13.gym.databinding.ActivityMainBinding
import es.etg.dam.pmdm13.gym.preferencias.GuardarPreferencia
import es.etg.dam.pmdm13.gym.preferencias.LeerPreferencia

class MainActivity : AppCompatActivity(){
    companion object{
        const val EXTRA_USUARIO = "Inicio:Usuario"
    }

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        actualizarNombreUsuario()


    }

    fun avanzarInicio(view: View){

        val abrirInicio = Intent(this, Inicio::class.java)
        startActivity(abrirInicio)

        almacenarPreferencia()

    }

    private fun almacenarPreferencia() {
        val nombreUsuario = binding.editTextUsuario.text.toString()
        val guardarPreferencia = GuardarPreferencia(this)
        guardarPreferencia.guardar(nombreUsuario)
    }

    fun avanzarActRegistrarse(view: View){
        val abrirRegistrarse = Intent(this, Registrarse::class.java)
        startActivity(abrirRegistrarse)
    }

    private fun actualizarNombreUsuario() {
        val leerPreferencia = LeerPreferencia(this)
        val nombre = leerPreferencia.leer()

        if (nombre != null) {
            binding.editTextUsuario.setText((nombre))
        }
    }

}