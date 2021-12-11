package com.samirmaciel.yugiohapp.modules.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.widget.doOnTextChanged
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.databinding.ActivityMainBinding
import com.samirmaciel.yugiohapp.shared.ClickListener
import com.samirmaciel.yugiohapp.shared.adapter.CardRVMainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), ClickListener {


    private var _binding : ActivityMainBinding? = null
    private val binding : ActivityMainBinding get() = _binding!!
    lateinit var rvCardRecyclerViewCardRVMainAdapter : CardRVMainAdapter

    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN) //Make keyboard stay overlayd layout
    }

    override fun onStart() {
        super.onStart()

        initRecycler()

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()

        binding.etSearchCard.doOnTextChanged{ text, start, before, count ->
            viewModel.searchCard(text.toString())
        }

        binding.btnToDeck.setOnClickListener{
            findNavController(R.id.fragmentContainer).navigate(R.id.action_cardDetailFragment_to_myDeckFragment)
            binding.motionLayoutMain.transitionToEnd()
        }


        viewModel.cardList.observe(this){
            rvCardRecyclerViewCardRVMainAdapter.cardList = it
            rvCardRecyclerViewCardRVMainAdapter.notifyDataSetChanged()
            binding.tvCountCards.setText("${resources.getText(R.string.title_count_cards)} ${it.size}")
        }

        binding.ivPerson.setOnClickListener{
            binding.rvCards.layoutManager!!.scrollToPosition(0)
        }
    }

    private fun initRecycler(){

        rvCardRecyclerViewCardRVMainAdapter  = CardRVMainAdapter {
            binding.motionLayoutMain.transitionToEnd()
            viewModel.selectedCard.value = it
            viewModel.findCardById(it.id)
        }

        binding.rvCards.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = rvCardRecyclerViewCardRVMainAdapter
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setRandomPersonImage(imageResource : Int){
        binding.ivPerson.setImageResource(imageResource)
    }

    override fun transitionToStart(route : String) {
        binding.motionLayoutMain.transitionToStart()
        setRandomPersonImage(viewModel.getRandomImagePerson())
        if(route == "MyDeck") {
            findNavController(R.id.fragmentContainer).navigate(R.id.action_myDeckFragment_to_cardDetailFragment)
        }
    }
}