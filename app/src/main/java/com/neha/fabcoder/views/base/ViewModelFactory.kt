package com.neha.fabcoder.views.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.neha.fabcoder.data.api.ApiHelper
import com.neha.fabcoder.viewmodel.ViewModelCocktails

class ViewModelFactory constructor(private val repository: ApiHelper): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelCocktails::class.java)) {
            ViewModelCocktails(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}