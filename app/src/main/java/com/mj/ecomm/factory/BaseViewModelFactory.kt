package com.mj.ecomm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mj.ecomm.base.BaseRepository
import com.mj.ecomm.base.BaseViewModel
import com.mj.ecomm.data.ProductDetailRepository
import com.mj.ecomm.data.ProductRepository
import com.mj.ecomm.product.ProductViewModel

  open class BaseViewModelFactory(val r : ProductRepository) : ViewModelProvider.Factory {



    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(r) as T
    }


}