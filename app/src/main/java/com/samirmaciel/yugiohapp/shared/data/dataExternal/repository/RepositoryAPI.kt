package com.samirmaciel.yugiohapp.shared.data.dataExternal.repository

import com.samirmaciel.yugiohapp.shared.data.dataExternal.model.DataResponse
import retrofit2.Call
import retrofit2.http.GET

interface RepositoryAPI {

    @GET("cardinfo.php?language=pt")
    fun getAllCards() : Call<DataResponse>
}