package com.samirmaciel.yugiohapp.modules.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.samirmaciel.yugiohapp.databinding.ActivityMainBinding
import com.samirmaciel.yugiohapp.getAllCards
import com.samirmaciel.yugiohapp.shared.adapter.CardPresenterAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var motionLayoutStarted = false

    private var _binding : ActivityMainBinding? = null
    private val binding : ActivityMainBinding get() = _binding!!
    lateinit var rvAdapter : CardPresenterAdapter

    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        initRecycler()

        binding.motionLayoutMain.setOnClickListener{
            if(motionLayoutStarted){
                binding.ivPerson.setImageResource(viewModel.getRandomImagePerson())
            }
            binding.motionLayoutMain.transitionToStart()
            motionLayoutStarted = false
        }

    }

    override fun onResume() {
        super.onResume()

        viewModel.listOfCards.observe(this){
            rvAdapter.submitList(it)
        }
    }

    private fun initRecycler(){
        rvAdapter = CardPresenterAdapter {
            binding.motionLayoutMain.transitionToEnd()
            viewModel.targetDetailCard.value = it
            motionLayoutStarted = true
        }
        binding.rvCards.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvCards.adapter = rvAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}