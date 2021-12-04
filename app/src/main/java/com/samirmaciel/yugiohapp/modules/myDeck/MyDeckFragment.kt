package com.samirmaciel.yugiohapp.modules.myDeck

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.databinding.FragmentMyDeckBinding
import com.samirmaciel.yugiohapp.shared.adapter.CardPresenterAdapter
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyDeckFragment : Fragment(R.layout.fragment_my_deck) {

    private var _binding : FragmentMyDeckBinding? = null
    private val binding : FragmentMyDeckBinding get() = _binding!!
    lateinit var rvAdapter : CardPresenterAdapter
    private val viewModel : MyDeckViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMyDeckBinding.bind(view)

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        binding.btnBack.setOnClickListener{
            binding.mlMyDeck.transitionToStart()
        }

        viewModel.cardList.observe(this){
            binding.tvNoneCards.visibility = View.GONE
            rvAdapter.submitList(it)
        }

    }

    private fun initRecyclerView(){
        rvAdapter = CardPresenterAdapter {
            Glide.with(this).load(it.image).into(binding.ivCard)
            binding.mlMyDeck.transitionToEnd()
        }
        binding.rvMyDeck.apply {
            adapter = rvAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
