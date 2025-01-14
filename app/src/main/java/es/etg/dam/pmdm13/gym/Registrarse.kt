package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import es.etg.dam.pmdm13.gym.data.CorreoEntity
import es.etg.dam.pmdm13.gym.data.CorreoUserEntity
import es.etg.dam.pmdm13.gym.data.UserDatabase
import es.etg.dam.pmdm13.gym.data.UserEntity
import es.etg.dam.pmdm13.gym.databinding.ActivityRegistrarseBinding
import es.etg.dam.pmdm13.gym.preferencias.EjecutarPreferencias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val ERROR_404_NOT_FOUNT_ = "Error 404!! Not Fount!!"

private const val TODOS_CARGADO = "Todo cargado"

class Registrarse : AppCompatActivity() {

    companion object{
        const val EXTRA_USUARIO = "MainActivity:Usuario"

        lateinit var database: UserDatabase
        const val DATABASE_USER = "usuario-db"
    }

    private lateinit var binding: ActivityRegistrarseBinding


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrarseBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Registrarse.database = Room.databaseBuilder(this,
                                                        UserDatabase::class.java,
                                                            DATABASE_USER).build()
        

        val volverMain = Intent(this, MainActivity::class.java)
        val text = ERROR_404_NOT_FOUNT_
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(this, text, duration)


        binding.imageButtonChrome.setOnClickListener {
            toast.show()
        }


        binding.imageButtonFacebook.setOnClickListener {
            toast.show()
        }

        binding.flechaVolver.setOnClickListener {
            startActivity(volverMain)
        }

        binding.btnRegistrar2.setOnClickListener {
            startActivity(volverMain)
            enviarInfo()
            guardar()
        }

    }

    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    private fun guardar() {
        val nombre = binding.editTextUsuarioNuevo.text
        val correos = binding.editTextCorreo.text

        var userId: Long = 0

        val usuario = UserEntity(0, nombre.toString());

        var lista: List<CorreoUserEntity>

        val userDao = database.userDao()
        val correoDao = database.correoDao()

        CoroutineScope(Dispatchers.IO).launch {

            userDao.insert(usuario)

            val correo = CorreoEntity(0, correos.toString(), userId)

            correoDao.insertCorreo(correo)

            lista = userDao.getAll()
        }

        Toast.makeText(this, TODOS_CARGADO,Toast.LENGTH_LONG).show()

    }


    private fun enviarInfo() {
        val textoCorreo = findViewById<EditText>(R.id.editTextCorreo).text
        val textoUsuario = findViewById<EditText>(R.id.editTextUsuarioNuevo).text
        val textoContrasenia = findViewById<EditText>(R.id.editTextContraseña).text

        val intent = Intent(this, MainActivity::class.java)
        val usuario = Usuario(textoCorreo.toString(), textoUsuario.toString(), textoContrasenia.toString())

        val ejecutarPreferencia = EjecutarPreferencias(this)
        ejecutarPreferencia.guardar(textoUsuario.toString())

        intent.putExtra(EXTRA_USUARIO, usuario)
        startActivity(intent)

    }
}