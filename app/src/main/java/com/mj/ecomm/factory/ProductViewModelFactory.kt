package com.mj.ecomm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mj.ecomm.base.BaseRepository
import com.mj.ecomm.data.ProductRepository
import com.mj.ecomm.product.ProductViewModel

class ProductViewModelFactory(private val repository: ProductRepository) : BaseViewModelFactory(repository) {

}
