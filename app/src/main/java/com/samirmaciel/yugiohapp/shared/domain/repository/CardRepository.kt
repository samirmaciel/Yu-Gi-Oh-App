package com.samirmaciel.yugiohapp.shared.domain.repository

import com.samirmaciel.yugiohapp.shared.data.dataInternal.model.Card

interface CardRepository {

    fun getAllCards() : List<Card>

    suspend fun findById(id : Long) : Card?

    suspend fun insertCard(card : Card)

    suspend fun deleteCard(card : Card)
}