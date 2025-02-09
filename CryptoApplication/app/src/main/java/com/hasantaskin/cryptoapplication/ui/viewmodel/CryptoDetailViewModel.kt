package com.hasantaskin.cryptoapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.hasantaskin.cryptoapplication.data.model.detail.CryptoDetailResponse
import com.hasantaskin.cryptoapplication.domain.usecase.GetCryptoDetailUseCase
import com.hasantaskin.cryptoapplication.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor( //Bu sınıf, CryptoDetailViewModel'i Hilt ile yönetilen bir ViewModel olarak işaretler.
    private val getCryptoDetailUseCase: GetCryptoDetailUseCase
) : ViewModel() {

    suspend fun loadCryptoDetailData( //Bu, kripto para birimi ID'sini alarak, ilgili detay verilerini getiren bir fonksiyondur.
        cryptoID: String
    ) : Resource<CryptoDetailResponse>{ //Resource sınıfındaki sonucu döndürür
        return getCryptoDetailUseCase.execute(cryptoID)
    }

}