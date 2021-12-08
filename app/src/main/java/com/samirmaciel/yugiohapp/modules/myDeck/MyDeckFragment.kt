package com.samirmaciel.yugiohapp.modules.myDeck

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.databinding.FragmentMyDeckBinding
import com.samirmaciel.yugiohapp.shared.ClickListener
import com.samirmaciel.yugiohapp.shared.adapter.CardRecycerViewAdapter
import com.samirmaciel.yugiohapp.shared.domain.model.Card
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyDeckFragment : Fragment(R.layout.fragment_my_deck) {

    lateinit var backToHomeAnimation : ClickListener
    private var _binding : FragmentMyDeckBinding? = null
    private val binding : FragmentMyDeckBinding get() = _binding!!
    lateinit var rvAdapter : CardRecycerViewAdapter
    private val viewModel : MyDeckViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMyDeckBinding.bind(view)

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        binding.ivArrowBack.setOnClickListener{
            backToHomeAnimation.transitionToStart("MyDeck")
        }

        binding.btnRemove.setOnClickListener{
            if(viewModel.selectedCard != null){
                deleteCard(viewModel.selectedCard!!)
            }
        }

        binding.btnBack.setOnClickListener{
            binding.mlMyDeck.transitionToStart()
        }

        viewModel.cardList.observe(this){
            rvAdapter.submitList(it)
            rvAdapter.notifyDataSetChanged()
        }

    }

    private fun initRecyclerView(){
        rvAdapter = CardRecycerViewAdapter {
            viewModel.selectedCard = it
            Glide.with(this).load(it.image).into(binding.ivCard)
            binding.mlMyDeck.transitionToEnd()
        }
        binding.rvMyDeck.apply {
            setHasFixedSize(true);
            setItemViewCacheSize(20);
            adapter = rvAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
        }
    }

    private fun deleteCard(card : Card){
        val alertDialog = AlertDialog.Builder(requireContext()).apply {
            setTitle("Deseja remover esta carta?")
            setPositiveButton("Sim", DialogInterface.OnClickListener{ _, _ ->
                viewModel.deleteCard(card)
                Snackbar.make(requireView(), "Carta deletada", Snackbar.LENGTH_SHORT).show()
                viewModel.getAllCards()
                binding.mlMyDeck.transitionToStart()
            })
            setNegativeButton("Não", null)
        }.create().show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            backToHomeAnimation = context as ClickListener
        }catch (e : Exception){

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
