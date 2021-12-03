package com.samirmaciel.yugiohapp.shared.data.dataExternal.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.samirmaciel.yugiohapp.shared.domain.model.Card
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

fun CardEntity.toCard() : Card {
    return Card(
        id = this.id!!,
        name = this.name!!,
        type = this.type,
        desc = this.desc,
        atk = this.atk,
        def = this.def,
        level = this.level,
        race = this.race,
        atribute = this.attribute,
        image = this.cardImages?.get(0)?.imageUrl,
        smallimage = this.cardImages?.get(0)?.imageUrlSmall,

    )
}
