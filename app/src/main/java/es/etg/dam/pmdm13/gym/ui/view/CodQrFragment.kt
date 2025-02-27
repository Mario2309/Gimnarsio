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
import es.etg.dam.pmdm13.gym.ui.state.CodQrUIState
import es.etg.dam.pmdm13.gym.ui.viewmodel.CodQrViewModel

class CodQrFragment : Fragment() {

    private val viewModel: CodQrViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_cod_qr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.estadoQr.observe(viewLifecycleOwner, Observer { estado ->
            when (estado) {
                is CodQrUIState.Loading -> {
                    // Mostrar un loader
                }
                is CodQrUIState.Success -> {
                    // Mostrar el QR en pantalla
                    Toast.makeText(context, "Código QR generado: ${estado.qrCode}", Toast.LENGTH_SHORT).show()
                }
                is CodQrUIState.Error -> {
                    // Mostrar mensaje de error
                    Toast.makeText(context, "Error...", Toast.LENGTH_SHORT).show()
                }
            }
        })

        // Simulamos generar un código QR
        viewModel.generarCodigoQR()
    }
}
