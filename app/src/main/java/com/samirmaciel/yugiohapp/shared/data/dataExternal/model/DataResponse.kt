package com.samirmaciel.yugiohapp.shared.data.dataExternal.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DataResponse(

    @SerializedName("data")
    val cardList : MutableList<CardEntity>

) : Parcelable{
    constructor() : this (mutableListOf())
}
