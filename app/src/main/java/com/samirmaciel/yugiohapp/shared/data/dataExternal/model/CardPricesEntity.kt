package com.samirmaciel.yugiohapp.shared.data.dataExternal.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardPricesEntity(

    @SerializedName("cardmarket_price")
    val cardMarketPrice : String?,

    @SerializedName("tcgplayer_price")
    val tcgPlayerPrice : String?,

    @SerializedName("ebay_price")
    val ebayPrice : String?,

    @SerializedName("amazon_price")
    val amazonPrice : String?,

    @SerializedName("coolstuffinc_price")
    val coolStuffincPrice : String?
) : Parcelable {
    constructor() : this("", "", "", "", "")
}
