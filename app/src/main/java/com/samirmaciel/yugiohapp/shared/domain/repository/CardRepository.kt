package com.samirmaciel.yugiohapp.shared.domain.repository

import com.samirmaciel.yugiohapp.shared.domain.model.Card

interface CardRepository {

    suspend fun getAllCards() : List<Card>

    suspend fun findById(id : Long) : Card?

    suspend fun insertCard(card : Card)

    suspend fun deleteCard(card : Card)
}