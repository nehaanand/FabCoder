package com.neha.fabcoder

import com.neha.fabcoder.data.api.ApiHelper


class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getAllDrinks() = apiHelper.getAllDrinks()
}