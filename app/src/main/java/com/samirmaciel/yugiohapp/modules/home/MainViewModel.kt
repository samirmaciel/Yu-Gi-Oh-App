package com.samirmaciel.yugiohapp.modules.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samirmaciel.yugiohapp.shared.model.CardPresenter

class MainViewModel : ViewModel() {

    var targetDetailCard : MutableLiveData<CardPresenter> = MutableLiveData()
}