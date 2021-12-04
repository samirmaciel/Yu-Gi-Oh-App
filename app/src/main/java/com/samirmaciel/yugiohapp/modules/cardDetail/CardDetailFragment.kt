package com.samirmaciel.yugiohapp.modules.cardDetail

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.databinding.FragmentCardDetailBinding
import com.samirmaciel.yugiohapp.modules.home.MainViewModel
import com.samirmaciel.yugiohapp.shared.ClickListener
import com.samirmaciel.yugiohapp.shared.domain.model.Card
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.lang.Exception

class CardDetailFragment : Fragment(R.layout.fragment_card_detail) {

    lateinit var activityClickListener : ClickListener

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

            binding.mlCardDetail.transitionToEnd{
                if(viewModel.targetCardState.value == 1){
                    binding.btnSave.visibility = View.GONE
                }
            }
        }

        binding.btnBack.setOnClickListener{

            binding.mlCardDetail.transitionToStart()
        }

        binding.ivArrowBack.setOnClickListener{

            activityClickListener.backViewToHome()

        }

        binding.btnSave.setOnClickListener{
            viewModel.insertCard(viewModel.targetDetailCard.value!!)
            viewModel.targetCardState.value = 1
            Toast.makeText(requireContext(), "Carta salva com sucesso!", Toast.LENGTH_SHORT).show()
        }

        viewModel.targetCardState.observe(this){
            if(it == 1){
                binding.btnSave.visibility = View.GONE
           }
        }

        viewModel.targetDetailCard.observe(this){

            Glide.with(requireContext()).load(it.image).transition(DrawableTransitionOptions.withCrossFade()).into(binding.ivCard)
            binding.textDescriptionCard.setText(it.desc)
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

            activityClickListener = context as ClickListener

        }catch (e : Exception){

        }
    }

    private fun checkCardInDatabaseInternal(card: Card){

    }
}