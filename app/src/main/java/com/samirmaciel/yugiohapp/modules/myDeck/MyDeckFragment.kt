package com.samirmaciel.yugiohapp.modules.myDeck

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.databinding.FragmentMyDeckBinding

class MyDeckFragment : Fragment(R.layout.fragment_my_deck) {

    private var _binding : FragmentMyDeckBinding? = null
    private val binding : FragmentMyDeckBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMyDeckBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
