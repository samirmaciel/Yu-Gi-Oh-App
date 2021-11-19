package com.samirmaciel.yugiohapp.modules.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samirmaciel.yugiohapp.shared.dataStore.RepositoryAPI
import com.samirmaciel.yugiohapp.shared.model.CardEntity
import com.samirmaciel.yugiohapp.shared.model.CardPresenter
import com.samirmaciel.yugiohapp.shared.model.DataResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository : RepositoryAPI) : ViewModel() {

    var targetDetailCard : MutableLiveData<CardEntity> = MutableLiveData()
    var listOfCards : MutableLiveData<MutableList<CardEntity>> = MutableLiveData()


    init {
        getAllCards()
    }

    fun getAllCards(){
        viewModelScope.launch {
            repository.getAllCards().enqueue(object : Callback<DataResponse>{
                override fun onResponse(
                    call: Call<DataResponse>,
                    response: Response<DataResponse>
                ) {
                    listOfCards.postValue(response.body()?.cardList)
                }

                override fun onFailure(call: Call<DataResponse>, t: Throwable) {

                }

            })
        }
    }
}