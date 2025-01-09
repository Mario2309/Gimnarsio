package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import es.etg.dam.pmdm13.gym.databinding.ActivityInicioBinding
import es.etg.dam.pmdm13.gym.preferencias.LeerPreferencia



@Suppress("DEPRECATION")
class Inicio : AppCompatActivity() {

    private lateinit var binding: ActivityInicioBinding

    private var tornoAbierto = true

    @SuppressLint("MissingInflatedId", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInicioBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val volverLogin = Intent(this, MainActivity::class.java)
        val mensaje = "Error!!"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(this, mensaje,duration)

        actualizarSaludo()

        binding.imageButtonUnlogg.setOnClickListener {
            startActivity(volverLogin)
        }

        binding.btmSelecEjer.setOnClickListener{
            toast.show()
        }


        binding.imageButtonUser.setOnClickListener {
            toast.show()
        }

    }

    fun abrirTorno(view: View){

        supportFragmentManager.commit {
            setReorderingAllowed(true)

            binding.fragmentContainerViewQr.visibility = View.VISIBLE
            binding.fragmentContainerViewCalendario.visibility = View.INVISIBLE

            binding.btnClose.visibility = View.VISIBLE
            binding.btmTorno.visibility = View.INVISIBLE
        }
    }

    fun cerrarTorno(view: View){

        supportFragmentManager.commit {
            setReorderingAllowed(true)

            binding.fragmentContainerViewCalendario.visibility = View.VISIBLE
            binding.fragmentContainerViewQr.visibility = View.INVISIBLE

            binding.btnClose.visibility = View.INVISIBLE
            binding.btmTorno.visibility = View.VISIBLE
        }
    }

    private fun actualizarSaludo() {
        val leerPreferencia = LeerPreferencia(this)
        val nombre = leerPreferencia.leer()

        if (nombre != null) {
            val textoNombre = binding.textViewNomUsu.setText((nombre))
        }
    }
}