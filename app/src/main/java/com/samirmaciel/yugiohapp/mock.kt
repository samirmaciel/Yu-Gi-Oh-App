package com.samirmaciel.yugiohapp

import com.samirmaciel.yugiohapp.shared.model.CardPresenter


fun getAllCards() : List<CardPresenter> {
    return listOf(
        CardPresenter(
            1,
            "Card1",
            "Card1",
            "200",
            "100",
            R.drawable.card1,
            R.drawable.card1,
        ),
        CardPresenter(
            2,
            "Card2",
            "Card2",
            "200",
            "100",
            R.drawable.card2,
            R.drawable.card2,
        ),
        CardPresenter(
            3,
            "Card3",
            "Card3",
            "200",
            "100",
            R.drawable.card3,
            R.drawable.card3,
        ),
        CardPresenter(
            4,
            "Card4",
            "Card4",
            "200",
            "100",
            R.drawable.card4,
            R.drawable.card4,
        ),


    )
}