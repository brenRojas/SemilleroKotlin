package com.brenda.arquitecturamvp.presenters

import com.brenda.arquitecturamvp.models.MensajeModel
import com.brenda.arquitecturamvp.views.MensajeViewListener

class MensajePresenter(private val vista:MensajeViewListener):MensajePresenterListener {

    val mMensajeModel = MensajeModel()

    override fun conseguirMensaje() {
        var mensajeConsultado = mMensajeModel.conultarMensajeBd()
        vista.saludar(mensajeConsultado)
    }

}