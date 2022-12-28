package com.mj.ecomm.data.remote

import com.mj.ecomm.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>

}