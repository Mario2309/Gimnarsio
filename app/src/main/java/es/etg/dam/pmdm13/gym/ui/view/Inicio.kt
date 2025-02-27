package es.etg.dam.pmdm13.gym.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import es.etg.dam.pmdm13.gym.databinding.ActivityInicioBinding
import es.etg.dam.pmdm13.gym.ui.state.TornoUIState
import es.etg.dam.pmdm13.gym.ui.viewmodel.TornoViewModel
import es.etg.dam.pmdm13.gym.ui.viewmodel.InicioViewModel

private const val ERROR_ = "Error!!"

@AndroidEntryPoint
@Suppress("DEPRECATION")
class Inicio : AppCompatActivity() {

    private lateinit var binding: ActivityInicioBinding
    private val viewModelTorno: TornoViewModel by viewModels()
    private val viewModelInicio: InicioViewModel by viewModels()

    @SuppressLint("MissingInflatedId", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observamos el nombre almacenado
        viewModelInicio.nombreUsuario.observe(this) { nombre ->
            binding.textViewNomUsu.text = nombre ?: ""
        }

        // Cargamos el nombre de usuario al iniciar la actividad
        viewModelInicio.cargarNombreUsuario()

        // Observamos el estado del torno
        viewModelTorno.estadoTorno.observe(this) { estado ->
            when (estado) {
                is TornoUIState.MostrarCalendario -> mostrarCalendario()
                is TornoUIState.MostrarQR -> mostrarQR()
            }
        }
    }

    fun mensajeError(view: View) {
        Toast.makeText(this, ERROR_, Toast.LENGTH_LONG).show()
    }

    fun volverLogin(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun avanzarSGM(view: View) {
        startActivity(Intent(this, SeleccionGrupoMuscular::class.java))
    }

    private fun mostrarCalendario() {
        binding.fragmentContainerViewCalendario.isVisible = true
        binding.fragmentContainerViewQr.isVisible = false
        binding.btnClose.isVisible = false
        binding.btmTorno.isVisible = true
    }

    private fun mostrarQR() {
        binding.fragmentContainerViewQr.isVisible = true
        binding.fragmentContainerViewCalendario.isVisible = false
        binding.btnClose.isVisible = true
        binding.btmTorno.isVisible = false
    }
}
