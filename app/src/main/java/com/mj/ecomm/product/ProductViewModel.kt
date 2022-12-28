package com.mj.ecomm.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mj.ecomm.base.BaseRepository
import com.mj.ecomm.base.BaseViewModel
import com.mj.ecomm.data.ProductRepository
import com.mj.ecomm.model.Product
import kotlinx.coroutines.launch
import java.lang.Exception

class ProductViewModel(override val repository: ProductRepository) : BaseViewModel(repository) {

    val products = MutableLiveData<List<Product>>()
    val error = MutableLiveData<String>()



      fun getProducts() {
        try {
            viewModelScope.launch {
                val response = repository.getProducts()

                if (response.isSuccessful) {
                    products.postValue(response.body())
                } else {
                    error.postValue(response.errorBody().toString())
                }

            }
        } catch (exception: Exception) {
            error.postValue("Something went wrong!!!")
        }


    }
}