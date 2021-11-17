package com.samirmaciel.yugiohapp.shared.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardImagesEntity (

    @SerializedName("id")
    val id : Long?,

    @SerializedName("image_url")
    val imageUrl : String?,

    @SerializedName("image_url_small")
    val imageUrlSmall : String?

) : Parcelable {
    constructor() : this(0, "", "")
}