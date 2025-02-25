package es.etg.dam.pmdm13.gym

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import es.etg.dam.pmdm13.gym.databinding.ActivityMainBinding
import es.etg.dam.pmdm13.gym.preferencias.EjecutarPreferencias

private const val CONCEDA_PERMISOS_EN_AJUSTES = "Conceda permisos en ajustes"
private const val ACCESO_A_LA_FUNCIONALIDAD_UNA_VEZ_ACEPTADO_EL_PERMISO = "Acceso a la funcionalidad una vez aceptado el permiso"

class MainActivity : AppCompatActivity(){

    companion object{
        const val CODIGO_RESPUESTA_PERMISO_INTERNET = 0
    }

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        actualizarNombreUsuario()

        comprobarPermisoInternet()

    }

    fun avanzarInicio(view: View){

        val abrirInicio = Intent(this, Inicio::class.java)
        startActivity(abrirInicio)

        almacenarPreferencia()

    }

    private fun almacenarPreferencia() {
        val nombreUsuario = binding.editTextUsuario.text.toString()
        val ejecutarPreferencia = EjecutarPreferencias(this)
        ejecutarPreferencia.guardar(nombreUsuario)
    }

    fun avanzarActRegistrarse(view: View){
        val abrirRegistrarse = Intent(this, Registrarse::class.java)
        startActivity(abrirRegistrarse)
    }

    private fun actualizarNombreUsuario() {
        val ejecutarPreferencia = EjecutarPreferencias(this)
        val nombre = ejecutarPreferencia.leer()

        if (nombre != null) {
            binding.editTextUsuario.setText((nombre))
        }
    }

    private fun comprobarPermisoInternet(){
        if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.INTERNET)
                            != PackageManager.PERMISSION_GRANTED){
            preguntarPermisoInternet()
        }
    }

    private fun preguntarPermisoInternet() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                                            Manifest.permission.INTERNET)){
            Toast.makeText(this, CONCEDA_PERMISOS_EN_AJUSTES, Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.INTERNET),
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
        when (requestCode){
            CODIGO_RESPUESTA_PERMISO_INTERNET -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(this,
                        ACCESO_A_LA_FUNCIONALIDAD_UNA_VEZ_ACEPTADO_EL_PERMISO, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, CONCEDA_PERMISOS_EN_AJUSTES, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}