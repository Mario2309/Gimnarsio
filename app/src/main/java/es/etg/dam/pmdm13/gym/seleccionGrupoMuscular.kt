package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.etg.dam.pmdm13.gym.databinding.ActivitySeleccionGrupoMuscularBinding
import es.etg.dam.pmdm13.gym.rwGrid.adaptadorElementoGrid
import es.etg.dam.pmdm13.gym.rwGrid.modeloVistaElementoGrid

class seleccionGrupoMuscular : AppCompatActivity() {

    private lateinit var binding: ActivitySeleccionGrupoMuscularBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeleccionGrupoMuscularBinding.inflate(layoutInflater)

        setContentView(binding.root)

        implementarRwGrid()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun implementarRwGrid() {
        val courseRv = findViewById<RecyclerView>(R.id.idRVCourses)

        val data = ArrayList<modeloVistaElementoGrid>()

        val layoutManager = GridLayoutManager(this, 2)

        courseRv.layoutManager = layoutManager

        val adapter = adaptadorElementoGrid(data, this)

        courseRv.adapter = adapter

        for (i in 1..4) {
            val image = android.R.drawable.btn_default
            val descripcion = "Descripción elemento $i"
            data.add(modeloVistaElementoGrid(descripcion, image))
        }

        adapter.notifyDataSetChanged()
    }

    fun volverInicio(view: View) {
        startActivity(Intent(this, Inicio::class.java))
    }
}