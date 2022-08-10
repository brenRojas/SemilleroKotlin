package com.joseluis.cuentas.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.joseluis.cuentas.R
import com.joseluis.cuentas.database.Database
import com.joseluis.cuentas.databinding.FragmentDetailBinding
import com.joseluis.cuentas.databinding.FragmentListaBinding
import com.joseluis.cuentas.ui.MainActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.joseluis.cuentas.dialogos.BorrarDialogFragment
import com.joseluis.cuentas.listenersui.FragmentsViewListener
import com.joseluis.cuentas.models.ClenteCuentas
import com.joseluis.cuentas.models.Cliente
import com.joseluis.cuentas.models.Cuenta
import com.joseluis.cuentas.presenters.CuentaPresenter

class DetailFragment : Fragment(),FragmentsViewListener,BorrarDialogFragment.DialogoListener {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    lateinit var presentador: CuentaPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presentador = CuentaPresenter(this)
        val args: DetailFragmentArgs by navArgs()
        if(args.operacion == Database.OPERACION_INSERTAR){
            (activity as MainActivity).title = "Nueva Cuenta"
            binding.btnEliminar.isEnabled = false
        }else{
            (activity as MainActivity).title = "Editar Cuenta"
            cargarDatos(args)
        }
        cargarUsuariosEspinner()

        binding.btnGuardar.setOnClickListener {
            when(args.operacion){
                Database.OPERACION_INSERTAR->{
                    crearCuenta()
                }
                Database.OPERACION_EDITAR->{
                    actualizarCuenta(args.posicion,args.cuentaCliente!!.mCuenta)
                }
            }
        }

        binding.btnEliminar.setOnClickListener {
            abrirDialogo(args.posicion)
        }
    }

    private fun cargarDatos(args: DetailFragmentArgs) {

        //buscamos el cliente en nuestro arreglo global
        //lo ponemos en el spinner y lo inhabilitamos

        //esta posicion es del array list de clientecuenta en la base de datos
        var posicion = args.posicion

        val cliente = args.cuentaCliente!!.mCliente
        val cuenta  = args.cuentaCliente!!.mCuenta

        //este indice es la posicion del cliente en la base de datos
        val indiceCliente  = Database.clientes.indexOf(cliente)

        binding.spnCliente.post(Runnable { binding.spnCliente.setSelection(indiceCliente) })
        binding.spnCliente.isEnabled = false
        binding.txtSaldo.setText(cuenta.saldo.toString())

        when(cuenta.tipo){
            Database.TIPO_DEBITO->binding.radDebito.isChecked = true
            Database.TIPO_CREDITO->binding.radCredito.isChecked = true
        }

    }

    private fun cargarUsuariosEspinner() {
        val spinnerArrayAdapter: ArrayAdapter<Cliente> =
            ArrayAdapter<Cliente>((activity as MainActivity).applicationContext, android.R.layout.simple_spinner_item, Database.clientes)
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // The drop down view
        binding.spnCliente.adapter = spinnerArrayAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun crearCuenta() {
        var mCliente = binding.spnCliente.selectedItem as Cliente
        var mCuenta = Cuenta()
        mCuenta.idCuenta    = Database.ids.random()
        mCuenta.numero      = Database.ids.random().toLong()
        mCuenta.saldo       = binding.txtSaldo.text.toString().toDouble()
        when(binding.grupoTipo.checkedRadioButtonId){
            R.id.radDebito->{
                mCuenta.tipo = Database.TIPO_DEBITO
            }
            R.id.radCredito->{
                mCuenta.tipo = Database.TIPO_CREDITO
            }
        }

        presentador.crearCuenta(mCliente,mCuenta)
    }

    private fun actualizarCuenta(posicion: Int,mCuenta:Cuenta) {
        var mCliente = binding.spnCliente.selectedItem as Cliente
        mCuenta.saldo       = binding.txtSaldo.text.toString().toDouble()
        when(binding.grupoTipo.checkedRadioButtonId){
            R.id.radDebito->{
                mCuenta.tipo = Database.TIPO_DEBITO
            }
            R.id.radCredito->{
                mCuenta.tipo = Database.TIPO_CREDITO
            }
        }

        presentador.actualizarCuenta(posicion,mCliente,mCuenta)
    }

    override fun onGetListSuccess(lista: ArrayList<ClenteCuentas>) {}
    override fun onGetListFail(razon: String) {}

    override fun onCuentaCreadaExito() {
        Toast.makeText(activity, "Cuenta agregada", Toast.LENGTH_SHORT).show()
        val action = DetailFragmentDirections.actionDetailFragmentToListaFragment()
        findNavController().navigate(action)
    }
    override fun onCuentaCreadaError() {
        Toast.makeText(activity, "Ocurrió un error al crear cuenta", Toast.LENGTH_SHORT).show()
    }

    override fun onCuentaEditadaExito() {
        Toast.makeText(activity, "Cuenta actualizada", Toast.LENGTH_SHORT).show()
        val action = DetailFragmentDirections.actionDetailFragmentToListaFragment()
        findNavController().navigate(action)
    }
    override fun onCuentaEditadaError() {
        Toast.makeText(activity, "Ocurrió un error al editar cuenta", Toast.LENGTH_SHORT).show()
    }

    override fun onCuentaEliminadaExito() {
        Toast.makeText(activity, "Cuenta Eliminada con éxito", Toast.LENGTH_SHORT).show()
        val action = DetailFragmentDirections.actionDetailFragmentToListaFragment()
        findNavController().navigate(action)
    }
    override fun onCuentaEliminadaFail() {
        Toast.makeText(activity, "Ocurrió un error al eliminar cuenta", Toast.LENGTH_SHORT).show()
    }

    private fun abrirDialogo(posicion:Int){
        val newFragment = BorrarDialogFragment(posicion,this)
        newFragment.show(activity!!.supportFragmentManager, "dialogborrar")
    }

    override fun borrar(posicion: Int) {
        presentador.eliminarCuenta(posicion)
    }
}