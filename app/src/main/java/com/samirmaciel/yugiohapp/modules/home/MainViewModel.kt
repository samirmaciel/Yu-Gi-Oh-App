package com.samirmaciel.yugiohapp.modules.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.shared.data.dataExternal.repository.RepositoryAPI
import com.samirmaciel.yugiohapp.shared.data.dataExternal.model.CardEntity
import com.samirmaciel.yugiohapp.shared.data.dataExternal.model.DataResponse
import com.samirmaciel.yugiohapp.shared.data.dataExternal.model.toCard
import com.samirmaciel.yugiohapp.shared.domain.model.Card
import com.samirmaciel.yugiohapp.shared.data.dataInternal.repository.CardRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.stream.Collectors

class MainViewModel(private val repositoryExternal : RepositoryAPI, private val repositoryInternal : CardRepositoryImpl) : ViewModel() {

    var targetDetailCard : MutableLiveData<Card> = MutableLiveData()
    var targetCardState : MutableLiveData<Int> = MutableLiveData(0)
    var listOfCards : MutableLiveData<MutableList<Card>> = MutableLiveData()


    init {
        getAllCards()
    }

    private fun getAllCards(){
        viewModelScope.launch {
            repositoryExternal.getAllCards().enqueue(object : Callback<DataResponse>{
                @RequiresApi(Build.VERSION_CODES.N)
                override fun onResponse(
                    call: Call<DataResponse>,
                    response: Response<DataResponse>
                ) {

                    val listCard = response.body()?.cardList?.stream()?.map {
                        it.toCard()
                    }?.collect(Collectors.toList())

                    listOfCards.postValue(listCard)
                }
                override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                }
            })
        }
    }

    fun findCardById(id : Long){
        viewModelScope.launch {
            val card = repositoryInternal.findById(id)
            if(card != null){
                targetCardState.postValue(1)
            }else{
                targetCardState.postValue(0)
            }
        }
    }

    fun insertCard(card: Card){
        viewModelScope.launch {
            repositoryInternal.insertCard(card)
        }
    }

    fun getRandomImagePerson() : Int {
        val chosenNumber = (1..15).random()
        return getMapImagePersons()[chosenNumber]!!
    }

    private fun getMapImagePersons() : Map<Int, Int>{
        return mapOf(
            1 to R.drawable.person1,
            2 to R.drawable.person2,
            3 to R.drawable.person3,
            4 to R.drawable.person4,
            5 to R.drawable.person5,
            6 to R.drawable.person6,
            7 to R.drawable.person7,
            8 to R.drawable.person8,
            9 to R.drawable.person9,
            10 to R.drawable.person10,
            11 to R.drawable.person11,
            12 to R.drawable.person12,
            13 to R.drawable.person13,
            14 to R.drawable.person14,
            15 to R.drawable.person15,
        )
    }
}