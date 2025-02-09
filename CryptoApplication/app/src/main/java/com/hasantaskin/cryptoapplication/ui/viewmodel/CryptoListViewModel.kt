package com.hasantaskin.cryptoapplication.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasantaskin.cryptoapplication.data.model.metadata.CryptoMetaData
import com.hasantaskin.cryptoapplication.domain.usecase.GetCryptoListUseCase
import com.hasantaskin.cryptoapplication.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val getCryptoListUseCase: GetCryptoListUseCase
) : ViewModel() {// Kripto para listesini alır, arama işlevini yönetir ve UI'ye veri sağlar.

    //mutable değişkeninde durumları tıtar veri,error,loading
    val cryptoMetaDataResponse = mutableStateOf<List<CryptoMetaData>>(listOf())
    var onError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    private var initialCryptoList = listOf<CryptoMetaData>()
    private var isSearchStarting = true

    init {//uygulama açıldığında tüm kripto para verilerinin yüklenmesi sağlanır
        loadAllCryptoMetaData()
    }

    fun loadAllCryptoMetaData() = viewModelScope.launch {
        isLoading.value = true //Veri yükleme başladığında true yapılır, işlem tamamlandığında false yapılır.
        when(val request = getCryptoListUseCase.execute()) {
            is Resource.Success -> {
                cryptoMetaDataResponse.value = request.data?.data ?: listOf()
                isLoading.value = false
            }
            is Resource.Error -> {
                onError.value = request.message.toString()
                isLoading.value = false
            }
            is Resource.Loading -> {
                isLoading.value = true
            }
        }
    }

    fun searchCryptoDataList(searchText: String) { //Kullanıcının arama metni ile kripto para listesinde arama yapmasını sağlar.
        val listToSearch = if (isSearchStarting) {
            cryptoMetaDataResponse.value
        } else {
            initialCryptoList

        }

        viewModelScope.launch(Dispatchers.Default) {
            if (searchText.isEmpty()) {
                cryptoMetaDataResponse.value = initialCryptoList
                isSearchStarting = true
                return@launch
            }//eğer arama yapılırsa arama döner yoksa default liste sıralanır

            val results = listToSearch.filter {
                it.metaName.contains(searchText.trim(), ignoreCase = true)
            }

            if (isSearchStarting) {
                initialCryptoList = cryptoMetaDataResponse.value
                isSearchStarting = false
            }

            cryptoMetaDataResponse.value = results
        }
    }
}