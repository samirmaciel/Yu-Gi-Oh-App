package com.samirmaciel.yugiohapp.shared.data.dataExternal.model

data class CardPresenter(

    val id : Long,
    val name : String,
    val description : String,
    val attak : String,
    val def : String,
    val image_poster : Int,
    val image_small : Int,
)
