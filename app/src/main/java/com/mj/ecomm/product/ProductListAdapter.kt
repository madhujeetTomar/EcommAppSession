package com.mj.ecomm.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mj.ecomm.R
import com.mj.ecomm.model.Product

class ProductListAdapter() :
    ListAdapter<Product, ProductListAdapter.LanguageViewHolder>(ProductDiffUtils()) {


    class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView
            get() = itemView.findViewById(R.id.tv_title)

        private val price: TextView
            get() = itemView.findViewById(R.id.tvPrice)

        private val image: ImageView
            get() = itemView.findViewById(R.id.productImage)

        fun bind(item: Product) {

            title.text = item.title
            price.text = item.price.toString()
            Glide.with(image.context).load(item.image).into(image);


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}

class ProductDiffUtils : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }
}

