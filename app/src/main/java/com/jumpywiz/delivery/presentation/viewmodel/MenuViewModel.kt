package com.jumpywiz.delivery.presentation.viewmodel

import androidx.lifecycle.*
import com.jumpywiz.delivery.model.MenuItem
import com.jumpywiz.delivery.model.RequestAnswer
import com.jumpywiz.delivery.repository.MenuRepos
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(private val repository: MenuRepos): ViewModel(), LifecycleObserver {
    private var data: MutableLiveData<List<MenuItem>> = MutableLiveData()
    init{
        loadFoodData("pizza")
    }

    fun getData() = data

    fun loadFoodData(foodType: String) {
        viewModelScope.launch {
            data.value = repository.loadData(foodType)
        }
    }

    fun getData(foodType: String) {
        viewModelScope.launch {
            data.value = repository.getNetData(foodType)
        }
    }
}