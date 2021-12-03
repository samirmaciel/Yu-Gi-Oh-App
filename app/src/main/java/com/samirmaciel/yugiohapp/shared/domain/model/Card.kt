package com.samirmaciel.yugiohapp.shared.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Card(

    @PrimaryKey
    val id : Long,

    @ColumnInfo
    val name : String,

    @ColumnInfo
    val type : String?,

    @ColumnInfo
    val desc : String?,

    @ColumnInfo
    val atk : Long?,

    @ColumnInfo
    val def : Long?,

    @ColumnInfo
    val level : Long?,

    @ColumnInfo
    val race : String?,

    @ColumnInfo
    val atribute : String?,

    @ColumnInfo
    val image : String?,

    @ColumnInfo
    val smallimage : String?

)
