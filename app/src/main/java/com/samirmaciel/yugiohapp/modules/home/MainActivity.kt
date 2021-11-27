package com.samirmaciel.yugiohapp.modules.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.samirmaciel.yugiohapp.R
import com.samirmaciel.yugiohapp.databinding.ActivityMainBinding
import com.samirmaciel.yugiohapp.shared.ClickListener
import com.samirmaciel.yugiohapp.shared.adapter.CardPresenterAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), ClickListener {


    private var _binding : ActivityMainBinding? = null
    private val binding : ActivityMainBinding get() = _binding!!
    lateinit var rvCardPresenterAdapter : CardPresenterAdapter

    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        initRecycler()

    }

    override fun onResume() {
        super.onResume()


        viewModel.listOfCards.observe(this){

            rvCardPresenterAdapter.submitList(it)
            binding.tvCountCards.setText("${resources.getText(R.string.title_count_cards)} ${it.size}")
        }
    }

    private fun initRecycler(){

        rvCardPresenterAdapter = CardPresenterAdapter {
            binding.motionLayoutMain.transitionToEnd()
            viewModel.targetDetailCard.value = it
        }

        binding.rvCards.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvCards.adapter = rvCardPresenterAdapter

    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null

    }

    private fun setRandomPersonImage(imageResource : Int){

        binding.ivPerson.setImageResource(imageResource)

    }

    override fun backViewToHome() {
        binding.motionLayoutMain.transitionToStart()
        setRandomPersonImage(viewModel.getRandomImagePerson())
    }
}