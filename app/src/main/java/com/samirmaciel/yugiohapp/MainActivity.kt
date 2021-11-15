package com.samirmaciel.yugiohapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.samirmaciel.yugiohapp.databinding.ActivityMainBinding
import com.samirmaciel.yugiohapp.shared.adapter.CardPresenterAdapter

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding : ActivityMainBinding get() = _binding!!
    lateinit var rvAdapter : CardPresenterAdapter

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

        rvAdapter.submitList(getAllCards())
    }

    private fun initRecycler(){
        rvAdapter = CardPresenterAdapter {

        }
        binding.rvCards.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvCards.adapter = rvAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}