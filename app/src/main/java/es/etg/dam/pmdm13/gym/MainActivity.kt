package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import es.etg.dam.pmdm13.gym.databinding.ActivityMainBinding
import es.etg.dam.pmdm13.gym.preferencias.GuardarPreferencia
import es.etg.dam.pmdm13.gym.preferencias.LeerPreferencia
import android.Manifest
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity(){
    companion object{
        const val EXTRA_USUARIO = "Inicio:Usuario"
        const val CODIGO_RESPUESTA_PERMISO_LEER_CALENDARIO = 0
    }

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        actualizarNombreUsuario()

        comprobarPermisoLecturaCalendario()

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

    private fun comprobarPermisoLecturaCalendario(){
        if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.READ_CALENDAR)
                            != PackageManager.PERMISSION_GRANTED){
            preguntarPermisoLecturaCalendario()
        } else {
            Toast.makeText(this,"Acceso a la funcionalidad", Toast.LENGTH_SHORT).show()
        }
    }

    private fun preguntarPermisoLecturaCalendario() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                                        Manifest.permission.READ_CALENDAR)){
            Toast.makeText(this, "Conceda permisos en ajustes", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_CALENDAR),
                Companion.CODIGO_RESPUESTA_PERMISO_LEER_CALENDARIO
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
            CODIGO_RESPUESTA_PERMISO_LEER_CALENDARIO -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(this,"Acceso a la funcionalidad una vez aceptado el permiso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Conceda permisos en ajustes", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}