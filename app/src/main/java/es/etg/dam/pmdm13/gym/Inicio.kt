package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import es.etg.dam.pmdm13.gym.databinding.ActivityInicioBinding
import es.etg.dam.pmdm13.gym.preferencias.EjecutarPreferencias


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
        val ejecutarPreferencia = EjecutarPreferencias(this)
        val nombre = ejecutarPreferencia.leer()

        if (nombre != null) {
            binding.textViewNomUsu.text = (nombre)
        }
    }
}