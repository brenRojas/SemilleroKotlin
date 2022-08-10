package com.cursokotlin.mvvmexample.domain

import com.cursokotlin.mvvmexample.data.QuoteRepository
import com.cursokotlin.mvvmexample.data.model.QuoteModel
import javax.inject.Inject

//Preparar para ser inyectado
class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {



    suspend operator fun invoke() = repository.getAllQuotes()

}