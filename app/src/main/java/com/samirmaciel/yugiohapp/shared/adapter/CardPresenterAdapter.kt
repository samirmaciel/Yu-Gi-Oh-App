package com.samirmaciel.yugiohapp.shared.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.samirmaciel.yugiohapp.databinding.RecyclerItemCardBinding
import com.samirmaciel.yugiohapp.shared.data.dataExternal.model.CardEntity

class CardPresenterAdapter(private val itemClick : (CardEntity) -> Unit) : ListAdapter<CardEntity, CardPresenterAdapter.ViewHolder>(CardDiffiUtil()) {


    inner class ViewHolder(private val bind : RecyclerItemCardBinding) : RecyclerView.ViewHolder(bind.root){

        fun bindCard(card : CardEntity, onItemClick : (CardEntity) -> Unit){
            Glide.with(bind.cardView).load(card.cardImages?.get(0)?.imageUrl).transition(
                DrawableTransitionOptions.withCrossFade()).into(bind.ivCard)
            bind.cardView.setOnClickListener{
                onItemClick(card)
            }
        }
    }

    class CardDiffiUtil : DiffUtil.ItemCallback<CardEntity>(){
        override fun areItemsTheSame(oldItem: CardEntity, newItem: CardEntity): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CardEntity, newItem: CardEntity): Boolean {
            return oldItem.name == newItem.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bind = RecyclerItemCardBinding.inflate(inflater, parent, false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCard(getItem(position), itemClick)
    }
}