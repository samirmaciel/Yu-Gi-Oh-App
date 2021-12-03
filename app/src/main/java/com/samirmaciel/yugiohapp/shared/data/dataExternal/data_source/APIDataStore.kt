package com.samirmaciel.yugiohapp.shared.data.dataExternal.data_source

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIDataStore {

    companion object {

        const val BASE_URL = "https://db.ygoprodeck.com/api/v7/"

        private var retrofit: Retrofit? = null

        fun getInstance(): Retrofit {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!

        }
    }
}