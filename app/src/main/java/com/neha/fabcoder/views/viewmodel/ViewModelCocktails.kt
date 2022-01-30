package com.neha.fabcoder.viewmodel
import android.telecom.Call
import com.neha.fabcoder.MainRepository
import com.neha.fabcoder.data.model.DrinksList
import javax.security.auth.callback.Callback

class ViewModelCocktails constructor(private val repository: MainRepository)  : ViewModel() {

    val drinksList = MutableLiveData<Resource<List<DrinksList>>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllDrinks() {

        val response = repository.getAllDrinks();
        response.enqueue(object : Callback<List<DrinksList>> {
            override fun onResponse(call: Call<List<DrinksList>>, response: Response<List<DrinksList>>) {
                drinksList.postValue(Resource.success(response.body()))
            }

            override fun onFailure(call: Call<List<DrinksList>>, t: Throwable) {
                drinksList.postValue(Resource.error(t.message.toString(),null))
            }
        })
    }
}