package com.samirmaciel.yugiohapp.modules.myDeck

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samirmaciel.yugiohapp.shared.domain.model.Card
import com.samirmaciel.yugiohapp.shared.data.dataInternal.repository.CardRepositoryImpl
import kotlinx.coroutines.launch

class MyDeckViewModel(private val repositoryInternal : CardRepositoryImpl) : ViewModel() {

    var cardList : MutableLiveData<List<Card>> = MutableLiveData()

    init {
        getAllCards()
    }

    private fun getAllCards(){
        viewModelScope.launch {
            cardList.postValue(repositoryInternal.getAllCards())
        }
    }

    fun deleteCard(card: Card){
        viewModelScope.launch {
            repositoryInternal.deleteCard(card)
        }
    }

}