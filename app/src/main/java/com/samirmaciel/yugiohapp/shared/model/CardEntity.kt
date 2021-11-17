package com.samirmaciel.yugiohapp.shared.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardEntity(

    @SerializedName("id")
    val id : Long?,

    @SerializedName("name")
    val name : String?,

    @SerializedName("type")
    val type : String?,

    @SerializedName("desc")
    val desc : String?,

    @SerializedName("atk")
    val atk : Long?,

    @SerializedName("def")
    val def : Long?,

    @SerializedName("level")
    val level : Long?,

    @SerializedName("race")
    val race : String?,

    @SerializedName("attribute")
    val attribute : String?,

    @SerializedName("card_sets")
    val cardSets : List<CardSetEntity>?,


    @SerializedName("card_images")
    val cardImages : List<CardImagesEntity>?,

    @SerializedName("card_prices")
    val cardPrices : List<CardPricesEntity>?




) : Parcelable {
    constructor() : this(0, "", "", "", 0, 0, 0, "", "", arrayListOf(), arrayListOf(), arrayListOf())
}
