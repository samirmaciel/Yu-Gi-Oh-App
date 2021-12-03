package com.samirmaciel.yugiohapp.shared.data.dataInternal.data_source

import androidx.room.*
import com.samirmaciel.yugiohapp.shared.domain.model.Card


@Dao
interface CardDao {

    @Query("SELECT * FROM card")
    suspend fun getAllCards() : List<Card>

    @Query ("SELECT * FROM card WHERE id == :id")
    suspend fun findById(id : Long) : Card?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card : Card)

    @Delete
    suspend fun deleteCard(card : Card)
}