package es.etg.dam.pmdm13.gym.ui.view

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import es.etg.dam.pmdm13.gym.databinding.ActivityMainBinding
import es.etg.dam.pmdm13.gym.ui.viewmodel.MainViewModel

private const val CONCEDA_PERMISOS_EN_AJUSTES = "Conceda permisos en ajustes"
private const val ACCESO_A_LA_FUNCIONALIDAD_UNA_VEZ_ACEPTADO_EL_PERMISO = "Acceso a la funcionalidad una vez aceptado el permiso"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val CODIGO_RESPUESTA_PERMISO_INTERNET = 0
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModelMain: MainViewModel by viewModels()

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observamos el nombre almacenado
        viewModelMain.nombreUsuario.observe(this) { nombre ->
            binding.editTextUsuario.setText(nombre ?: "")
        }

        // Cargamos la preferencia al iniciar la actividad
        viewModelMain.cargarNombreUsuario()

        comprobarPermisoInternet()
    }

    fun avanzarInicio(view: View) {
        val abrirInicio = Intent(this, Inicio::class.java)
        startActivity(abrirInicio)

        // Guardamos el nombre de usuario en la preferencia
        val nombreUsuario = binding.editTextUsuario.text.toString()
        viewModelMain.guardarNombreUsuario(nombreUsuario)
    }

    fun avanzarActRegistrarse(view: View) {
        val abrirRegistrarse = Intent(this, Registrarse::class.java)
        startActivity(abrirRegistrarse)
    }

    private fun comprobarPermisoInternet() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED
        ) {
            preguntarPermisoInternet()
        }
    }

    private fun preguntarPermisoInternet() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)) {
            Toast.makeText(this, CONCEDA_PERMISOS_EN_AJUSTES, Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.INTERNET),
                CODIGO_RESPUESTA_PERMISO_INTERNET
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CODIGO_RESPUESTA_PERMISO_INTERNET -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(this, ACCESO_A_LA_FUNCIONALIDAD_UNA_VEZ_ACEPTADO_EL_PERMISO, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, CONCEDA_PERMISOS_EN_AJUSTES, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
