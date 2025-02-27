package es.etg.dam.pmdm13.gym.ui.components

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.etg.dam.pmdm13.gym.R

class GridAdapter(private val eList: List<GridItemViewModel>, private val context: Context): RecyclerView.Adapter<GridAdapter.ViewHolder>(){

    private var onClickListener: OnClickListener? = null


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.elemento_rw_grid, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = eList[position]

        holder.imagenVista.setImageResource(itemViewModel.image)
        holder.textoVista.text = itemViewModel.texto

        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position, itemViewModel)
        }
    }
    override fun getItemCount(): Int {
        return eList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textoVista: TextView = itemView.findViewById(R.id.textoElementoGrid)
        val imagenVista: ImageView = itemView.findViewById(R.id.imagenElementoGrid)
    }

    interface OnClickListener {
        fun onClick(position: Int, model: GridItemViewModel)
    }


    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }
}