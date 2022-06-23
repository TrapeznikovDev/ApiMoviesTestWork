package com.template.apimovies.activities.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.apimovies.ComponentManager
import com.template.apimovies.databinding.ActivityMainBinding
import com.template.apimovies.di.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RecyclerAdapter
    private val model: MainActivityViewModel by viewModels { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComponentManager.instance.getActivityComponent(this).inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RecyclerAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)
        model.mProgress.observe(this){
            when(it) {
                LoadingState.isLoading -> binding.progressBar.visibility = View.VISIBLE
                LoadingState.initial -> binding.progressBar.visibility = View.GONE
            }
        }
        model.mData.observe(this){
            adapter.setData(it)
        }
    }
}