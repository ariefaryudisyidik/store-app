package com.ariefaryudisyidik.store.ui.storelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ariefaryudisyidik.store.data.local.entity.Store
import com.ariefaryudisyidik.store.domain.usecase.GetStoreListUseCase
import com.ariefaryudisyidik.store.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StoreListViewModel @Inject constructor(
    getStoreListUseCase: GetStoreListUseCase
) : ViewModel() {

    val getStoreList = getStoreListUseCase.invoke().asLiveData()
    val navigateToStoreDetail = MutableLiveData<Event<Store>>()
    fun onStoresClicked(store: Store) {
        navigateToStoreDetail.postValue(Event(store))
    }
}