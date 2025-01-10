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


private const val ERROR_ = "Error!!"

@Suppress("DEPRECATION")
class Inicio : AppCompatActivity() {

    private lateinit var binding: ActivityInicioBinding

    @SuppressLint("MissingInflatedId", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInicioBinding.inflate(layoutInflater)

        setContentView(binding.root)

        actualizarSaludo()

    }

    fun mensajeError(view: View){
        Toast.makeText(this, ERROR_,Toast.LENGTH_LONG).show()
    }

    fun volverLogin(view: View){
        startActivity(Intent(this, MainActivity::class.java))
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
            binding.textViewNomUsu.text = (nombre)
        }
    }
}