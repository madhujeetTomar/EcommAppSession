package com.mj.ecomm.data

import com.mj.ecomm.base.BaseRepository
import com.mj.ecomm.data.remote.ApiService
import com.mj.ecomm.model.Product
import retrofit2.Response

class ProductRepository(private val apiService: ApiService) : BaseRepository(){

    suspend fun getProducts(): Response<List<Product>> = apiService.getProducts()
}