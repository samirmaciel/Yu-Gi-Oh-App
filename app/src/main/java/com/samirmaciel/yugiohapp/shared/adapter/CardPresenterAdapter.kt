package com.samirmaciel.yugiohapp.shared.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samirmaciel.yugiohapp.databinding.RecyclerItemCardBinding
import com.samirmaciel.yugiohapp.shared.model.CardPresenter

class CardPresenterAdapter(val itemClick : (CardPresenter) -> Unit) : ListAdapter<CardPresenter, CardPresenterAdapter.ViewHolder>(CardDiffiUtil()) {


    inner class ViewHolder(private val bind : RecyclerItemCardBinding) : RecyclerView.ViewHolder(bind.root){

        fun bindCard(card : CardPresenter, onItemClick : (CardPresenter) -> Unit){
            bind.imageViewCard.setImageResource(card.image_poster)
            bind.cardView.setOnClickListener{
                onItemClick(card)
            }
        }
    }

    class CardDiffiUtil : DiffUtil.ItemCallback<CardPresenter>(){
        override fun areItemsTheSame(oldItem: CardPresenter, newItem: CardPresenter): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CardPresenter, newItem: CardPresenter): Boolean {
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