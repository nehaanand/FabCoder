package com.neha.fabcoder.data.api

class ApiHelper(private val apiService: ApiService) {

    fun getAllDrinks() = apiService.getAllDrinks();
}