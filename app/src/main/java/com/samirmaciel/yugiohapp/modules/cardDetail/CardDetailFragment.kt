package com.samirmaciel.yugiohapp.modules.cardDetail

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.databinding.FragmentCardDetailBinding
import com.samirmaciel.yugiohapp.modules.home.MainViewModel
import com.samirmaciel.yugiohapp.shared.ClickListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.lang.Exception

class CardDetailFragment : Fragment(R.layout.fragment_card_detail) {

    lateinit var backToHomeAnimation : ClickListener

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
            binding.mlCardDetail.transitionToEnd()
        }

        binding.btnBack.setOnClickListener{
            binding.mlCardDetail.transitionToStart()
        }

        binding.ivArrowBack.setOnClickListener{
            viewModel.targetCardState.value = 0
            backToHomeAnimation.transitionToStart("CardDetail")
        }

        binding.tvSave.setOnClickListener{
            viewModel.insertCard(viewModel.targetDetailCard.value!!)
            binding.tvSave.animate().apply {
                duration = 500
                rotationY(360f)
            }.withEndAction {
                binding.tvSave.apply {
                    text = resources.getText(R.string.title_salved)
                    setTextColor(Color.parseColor("#5DB96D"))
                }
            }
        }

        viewModel.targetCardState.observe(this){
            checkTargetCard(it)
        }

        viewModel.targetDetailCard.observe(this){
            Glide.with(requireContext()).load(it.image).transition(DrawableTransitionOptions.withCrossFade()).into(binding.ivCard)
            binding.textDescriptionCard.setText(it.desc)
            binding.titleCard.setText(it.name)
            binding.typeCard.setText(it.type)
            binding.powerCard.setText("${it.atk}/${it.def}")
        }
    }

    private fun checkTargetCard(numberState : Int) {
        if (numberState == 1) {
            binding.tvSave.apply {
                text = resources.getText(R.string.title_salved)
                setTextColor(Color.parseColor("#5DB96D"))
            }
        } else {
            binding.tvSave.apply {
                text = resources.getText(R.string.title_save)
                setTextColor(Color.parseColor("#ffffff"))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            backToHomeAnimation = context as ClickListener
        }catch (e : Exception){
        }
    }

}