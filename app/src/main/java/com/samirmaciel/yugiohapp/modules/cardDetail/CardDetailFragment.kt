package com.samirmaciel.yugiohapp.modules.cardDetail

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.databinding.FragmentCardDetailBinding
import com.samirmaciel.yugiohapp.modules.home.MainViewModel
import com.samirmaciel.yugiohapp.shared.OnClickListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.lang.Exception

class CardDetailFragment : Fragment(R.layout.fragment_card_detail) {

    lateinit var onClickListenerListener : OnClickListener

    private var transitionStated = false

    private var _binding : FragmentCardDetailBinding? = null
    private val binding : FragmentCardDetailBinding get() = _binding!!
    private val viewModel : MainViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCardDetailBinding.bind(view)
    }

    override fun onResume() {
        super.onResume()

        binding.ivCard.setOnClickListener{
            if(transitionStated){
                binding.mlCardDetail.transitionToStart()
                transitionStated = false
            }else{
                binding.mlCardDetail.transitionToEnd()
                transitionStated = true
            }
        }

        binding.ivArrowBack.setOnClickListener{
            onClickListenerListener.backToHome()
        }

        viewModel.targetDetailCard.observe(this){
            Glide.with(requireContext()).load(it.cardImages?.get(0)?.imageUrl).transition(DrawableTransitionOptions.withCrossFade()).into(binding.ivCard)
            binding.descriptionCard.setText(it.desc)
            binding.titleCard.setText(it.name)
            binding.typeCard.setText(it.type)
            binding.powerCard.setText("${it.atk}/${it.def}")
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onClickListenerListener = context as OnClickListener
        }catch (e : Exception){

        }
    }
}