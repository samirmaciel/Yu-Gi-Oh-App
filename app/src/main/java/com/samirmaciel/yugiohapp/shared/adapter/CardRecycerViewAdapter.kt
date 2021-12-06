package com.samirmaciel.yugiohapp.shared.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.databinding.RecyclerItemCardBinding
import com.samirmaciel.yugiohapp.shared.domain.model.Card

class CardRecycerViewAdapter(private val itemClick : (Card) -> Unit) : ListAdapter<Card, CardRecycerViewAdapter.ViewHolder>(CardDiffiUtil()) {


    inner class ViewHolder(private val bind : RecyclerItemCardBinding) : RecyclerView.ViewHolder(bind.root){

        fun bindCard(card : Card, onItemClick : (Card) -> Unit){
            Glide.with(bind.cardView).load(card.smallimage).placeholder(R.drawable.placeholder_card).transition(
                DrawableTransitionOptions.withCrossFade()).into(bind.ivCard)
            bind.cardView.setOnClickListener{
                onItemClick(card)
            }
        }
    }

    class CardDiffiUtil : DiffUtil.ItemCallback<Card>(){
        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
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