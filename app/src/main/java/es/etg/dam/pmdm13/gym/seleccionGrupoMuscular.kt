package es.etg.dam.pmdm13.gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.etg.dam.pmdm13.gym.databinding.ActivitySeleccionGrupoMuscularBinding
import es.etg.dam.pmdm13.gym.rwGrid.adaptadorElementoGrid
import es.etg.dam.pmdm13.gym.rwGrid.modeloVistaElementoGrid

private const val ERROR_ = "Error!!"

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
        val rvGrid = findViewById<RecyclerView>(R.id.rvGrid)

        val data = ArrayList<modeloVistaElementoGrid>()

        val layoutManager = GridLayoutManager(this, 2)

        rvGrid.layoutManager = layoutManager

        val adapter = adaptadorElementoGrid(data, this)

        rvGrid.adapter = adapter

        val arrayGM = resources.getStringArray(R.array.gruposMusculares)

        val arrayIGM = cargarImagenes()

        for (i in arrayGM.indices) {
            val image = arrayIGM[i]
            val descripcion = arrayGM[i]
            data.add(modeloVistaElementoGrid(descripcion, image))
        }

        adapter.notifyDataSetChanged()

        adapter.setOnClickListener(object :
            adaptadorElementoGrid.OnClickListener {
            override fun onClick(position: Int, model: modeloVistaElementoGrid) {
                val msg:String = "Ha saleccionado el elemento ${model.texto}"
                Toast.makeText(this@seleccionGrupoMuscular, msg, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun msgError(view: View){
        Toast.makeText(this, ERROR_, Toast.LENGTH_SHORT).show()
    }

    fun volverInicio(view: View) {
        startActivity(Intent(this, Inicio::class.java))
    }

    private fun cargarImagenes(): Array<Int> {

        val imageArray = arrayOf(
            R.drawable.pecho,
            R.drawable.espalda,
            R.drawable.gluteos,
            R.drawable.cuadriceps,
            R.drawable.biceps,
            R.drawable.triceps,
            R.drawable.hombro,
            R.drawable.pantorrillas
            )

        return imageArray
    }
}