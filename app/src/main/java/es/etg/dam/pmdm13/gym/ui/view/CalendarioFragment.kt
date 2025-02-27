package es.etg.dam.pmdm13.gym.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import es.etg.dam.pmdm13.gym.R
import es.etg.dam.pmdm13.gym.ui.state.CalendarioUIState
import es.etg.dam.pmdm13.gym.ui.viewmodel.CalendarioViewModel

class CalendarioFragment : Fragment() {

    private val viewModel: CalendarioViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_calendario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.estadoCalendario.observe(viewLifecycleOwner, Observer { estado ->
            when (estado) {
                is CalendarioUIState.Loading -> {
                    // Mostrar un loader
                }
                is CalendarioUIState.Success -> {
                    // Actualizar UI con los eventos
                    Toast.makeText(context, "Eventos cargados: ${estado.eventos}", Toast.LENGTH_SHORT).show()
                }
                is CalendarioUIState.Error -> {
                    // Mostrar mensaje de error
                    Toast.makeText(context, estado.mensaje, Toast.LENGTH_SHORT).show()
                }
            }
        })


    }
}
