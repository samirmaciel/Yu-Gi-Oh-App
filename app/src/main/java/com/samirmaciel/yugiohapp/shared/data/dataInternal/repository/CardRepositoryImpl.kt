package com.samirmaciel.yugiohapp.shared.data.dataInternal.repository

import com.samirmaciel.yugiohapp.shared.data.dataInternal.data_source.CardDao
import com.samirmaciel.yugiohapp.shared.data.dataInternal.model.Card
import com.samirmaciel.yugiohapp.shared.domain.repository.CardRepository

class CardRepositoryImpl(private val dao : CardDao): CardRepository {

    override fun getAllCards(): List<Card> {
        return dao.getAllCards()
    }

    override suspend fun findById(id: Long): Card? {
        return dao.findById(id)
    }

    override suspend fun insertCard(card: Card) {
        dao.insertCard(card)
    }

    override suspend fun deleteCard(card: Card) {
        dao.deleteCard(card)
    }
}