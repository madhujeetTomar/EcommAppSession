package com.mj.ecomm.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mj.ecomm.R
import com.mj.ecomm.data.ProductRepository
import com.mj.ecomm.data.remote.ApiInstance
import com.mj.ecomm.databinding.ActivityProductListBinding
import com.mj.ecomm.factory.BaseViewModelFactory
import com.mj.ecomm.factory.ProductViewModelFactory

class ProductList : AppCompatActivity() {

    lateinit var productListBinding: ActivityProductListBinding

    lateinit var repository: ProductRepository
    lateinit var viewModel: ProductViewModel
    lateinit var adapter: ProductListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        viewModel.getProducts()
        viewModel.products.observe(this, Observer {

            adapter.submitList(it)

            productListBinding.recyProducts.layoutManager = LinearLayoutManager(this)
            productListBinding.recyProducts.setHasFixedSize(true)
            productListBinding.recyProducts.adapter = adapter



            for (product in it) {
                println(product.title)
            }
        })
    }

    fun init() {
        productListBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)

        repository = ProductRepository(ApiInstance.getApiService())

        viewModel = ViewModelProvider(
            this,
            BaseViewModelFactory(repository)
        ).get(ProductViewModel::class.java)
        productListBinding.lifecycleOwner = this
        productListBinding.viewmodel = viewModel
        adapter = ProductListAdapter()
    }
}