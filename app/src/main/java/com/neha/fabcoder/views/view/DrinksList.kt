package com.neha.fabcoder.views.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.neha.fabcoder.R
import com.neha.fabcoder.adapter.DrinksListAdapter
import com.neha.fabcoder.data.model.DrinksList
import com.neha.fabcoder.data.api.ApiHelper
import com.neha.fabcoder.databinding.ActivityCocktailsListBinding
import com.neha.fabcoder.utilities.Status
import com.neha.fabcoder.viewmodel.ViewModelCocktails
import com.neha.fabcoder.views.base.ViewModelFactory

class DrinksList : AppCompatActivity() {

    private lateinit var drinksListViewModel: ViewModelCocktails
    private lateinit var adapter: DrinksListAdapter
    private val apiService = ApiService.getInstance()
    private lateinit var binding: ActivityCocktailsListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cocktails_list)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DrinksListAdapter(arrayListOf())
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        drinksListViewModel.drinksList.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    binding.recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING-> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<DrinksList>) {
        adapter.addData(users)
        adapter.notifydDataSetChanged()
    }

    private fun setupViewModel() {
        drinksListViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilde))
        ).get(ViewModelCocktails::class.java)
    }
}