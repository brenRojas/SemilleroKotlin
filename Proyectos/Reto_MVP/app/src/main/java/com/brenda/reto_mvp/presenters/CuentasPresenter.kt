package com.brenda.reto_mvp.presenters

import com.brenda.reto_mvp.datos.Cuenta
import com.brenda.reto_mvp.dialog.AgregarCuentaDialog
import com.brenda.reto_mvp.dialog.DialogListener
import com.brenda.reto_mvp.models.CuentasModel
import com.brenda.reto_mvp.views.CuentasViewsListener
import com.brenda.reto_mvp.views.UserViewsListener

class CuentasPresenter (val view: UserViewsListener) : CuentasPresenterListener {

    val mUser = CuentasModel(this)

    override fun obtenerUsuarios() {
        mUser.obtenerListaCuentas()
    }

    override fun onRecibirLista(listaCuentas: ArrayList<Cuenta>) {
        view.obtenerLista(listaCuentas)
    }

}