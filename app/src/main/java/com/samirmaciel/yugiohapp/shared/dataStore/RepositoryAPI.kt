package com.samirmaciel.yugiohapp.shared.dataStore

import com.samirmaciel.yugiohapp.shared.model.CardEntity
import com.samirmaciel.yugiohapp.shared.model.DataResponse
import retrofit2.Call
import retrofit2.http.GET

interface RepositoryAPI {

    @GET("cardinfo.php?language=pt")
    fun getAllCards() : Call<DataResponse>
}