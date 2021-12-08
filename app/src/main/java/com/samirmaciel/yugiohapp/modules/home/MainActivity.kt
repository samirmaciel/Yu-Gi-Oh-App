package com.samirmaciel.yugiohapp.modules.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.widget.doOnTextChanged
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.databinding.ActivityMainBinding
import com.samirmaciel.yugiohapp.shared.ClickListener
import com.samirmaciel.yugiohapp.shared.adapter.CardRecycerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), ClickListener {


    private var _binding : ActivityMainBinding? = null
    private val binding : ActivityMainBinding get() = _binding!!
    lateinit var rvCardRecycerViewAdapter : CardRecycerViewAdapter

    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    override fun onStart() {
        super.onStart()

        initRecycler()

    }

    override fun onResume() {
        super.onResume()

        binding.etSearchCard.doOnTextChanged{ text, start, before, count ->
            searchCard(text.toString())
        }

        binding.btnToDeck.setOnClickListener{
            findNavController(R.id.fragmentContainer).navigate(R.id.action_cardDetailFragment_to_myDeckFragment)
            binding.motionLayoutMain.transitionToEnd()
        }

        viewModel.listOfCards.observe(this){
            rvCardRecycerViewAdapter.submitList(it)
            binding.tvCountCards.setText("${resources.getText(R.string.title_count_cards)} ${it.size}")
        }
    }

    private fun initRecycler(){

        rvCardRecycerViewAdapter = CardRecycerViewAdapter {
            binding.motionLayoutMain.transitionToEnd()
            viewModel.targetDetailCard.value = it
            viewModel.findCardById(it.id)
        }

        binding.rvCards.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = rvCardRecycerViewAdapter
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setRandomPersonImage(imageResource : Int){
        binding.ivPerson.setImageResource(imageResource)
    }

    private fun searchCard(keyWord : String){
        rvCardRecycerViewAdapter.submitList(viewModel.searchCard(keyWord))
        rvCardRecycerViewAdapter.notifyDataSetChanged()
    }

    override fun transitionToStart(route : String) {
        binding.motionLayoutMain.transitionToStart()
        setRandomPersonImage(viewModel.getRandomImagePerson())
        if(route == "MyDeck") {
            findNavController(R.id.fragmentContainer).navigate(R.id.action_myDeckFragment_to_cardDetailFragment)
        }
    }
}