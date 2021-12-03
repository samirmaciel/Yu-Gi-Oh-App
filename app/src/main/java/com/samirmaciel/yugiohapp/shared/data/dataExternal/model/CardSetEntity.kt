package com.samirmaciel.yugiohapp.shared.data.dataExternal.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardSetEntity(

    @SerializedName("set_name")
    val setName : String?,

    @SerializedName("set_code")
    val setCode : String?,

    @SerializedName("set_rarity")
    val setRarity : String?,

    @SerializedName("set_rarity_code")
    val setRarityCode : String?,

    @SerializedName("set_price")
    val setPrice : String?


) : Parcelable {
    constructor() : this("", "", "", "", "")
}
