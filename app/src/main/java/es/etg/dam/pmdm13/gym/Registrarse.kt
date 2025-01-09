package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import es.etg.dam.pmdm13.gym.data.UserDatabase
import es.etg.dam.pmdm13.gym.data.UserEntity
import es.etg.dam.pmdm13.gym.databinding.ActivityRegistrarseBinding
import es.etg.dam.pmdm13.gym.preferencias.GuardarPreferencia
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Registrarse : AppCompatActivity() {

    companion object{
        //Constante para el paso de extras
        const val EXTRA_USUARIO = "MainActivity:Usuario"

        lateinit var database: UserDatabase
        const val DATABASE_USER = "usuario-db"
    }

    private lateinit var binding: ActivityRegistrarseBinding


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrarseBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_registrarse)

        Registrarse.database = Room.databaseBuilder(this,
                                                        UserDatabase::class.java,
                                                            DATABASE_USER).build()
        

        val volverMain = Intent(this, MainActivity::class.java)
        val btnRegistrar:Button = findViewById(R.id.btnRegistrar2)
        val btnFlecha:ImageButton = findViewById(R.id.flechaVolver)
        val text = "Error 404!! Not Fount!!"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(this, text, duration)
        val btnChrome:ImageButton = findViewById(R.id.imageButtonChrome)
        val btnFacebook:ImageButton = findViewById(R.id.imageButtonFacebook)

        btnChrome.setOnClickListener {
            toast.show()
        }

        btnFacebook.setOnClickListener {
            toast.show()
        }

        btnFlecha.setOnClickListener {
            startActivity(volverMain)
        }

        btnRegistrar.setOnClickListener {
            startActivity(volverMain)
            enviarInfo()
            guardar()
        }


    }

    private fun guardar() {
        val nombre = findViewById<EditText>(R.id.editTextUsuarioNuevo).text
        val correo = findViewById<EditText>(R.id.editTextCorreo).text

        val usuario = UserEntity(0, nombre.toString(), correo.toString());

        val userDao = database.userDao()

        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(usuario)
        }

    }

    private fun enviarInfo() {
        val textoCorreo = findViewById<EditText>(R.id.editTextCorreo).text
        val textoUsuario = findViewById<EditText>(R.id.editTextUsuarioNuevo).text
        val textoContrasenia = findViewById<EditText>(R.id.editTextContraseña).text

        val intent = Intent(this, MainActivity::class.java)
        val usuario = Usuario(textoCorreo.toString(), textoUsuario.toString(), textoContrasenia.toString())

        val guardarPreferencia = GuardarPreferencia(this)
        guardarPreferencia.guardar(textoUsuario.toString())

        intent.putExtra(EXTRA_USUARIO, usuario)
        startActivity(intent)

    }
}