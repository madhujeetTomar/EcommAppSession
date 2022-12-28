package com.mj.ecomm.base

import androidx.lifecycle.ViewModel

open class BaseViewModel(open val repository: BaseRepository) : ViewModel() {
}