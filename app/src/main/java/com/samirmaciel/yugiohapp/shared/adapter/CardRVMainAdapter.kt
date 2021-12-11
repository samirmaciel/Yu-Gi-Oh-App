package com.samirmaciel.yugiohapp.shared.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.shared.domain.model.Card

class CardRVMainAdapter(val itemClick: (Card) -> Unit) : RecyclerView.Adapter<CardRVMainAdapter.AdapterViewHolder>(){

    var cardList : List<Card> = arrayListOf()

    inner class AdapterViewHolder(private val itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItem(card: Card, itemClick : (Card) -> Unit){
            Glide.with(itemView).load(card.smallimage).placeholder(R.drawable.placeholder_card).transition(
                DrawableTransitionOptions.withCrossFade()).into(itemView.findViewById<ImageView>(R.id.ivCard))

            itemView.findViewById<ImageView>(R.id.ivCard).setOnClickListener{
                itemClick(card)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_card, parent, false))
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bindItem(cardList.get(position), itemClick)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

}