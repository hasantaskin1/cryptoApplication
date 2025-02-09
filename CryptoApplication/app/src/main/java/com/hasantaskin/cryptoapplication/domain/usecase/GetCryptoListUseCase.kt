package com.hasantaskin.cryptoapplication.domain.usecase

import com.hasantaskin.cryptoapplication.data.model.metadata.CryptoMetaDataResponse
import com.hasantaskin.cryptoapplication.domain.repository.HomeRepository
import com.hasantaskin.cryptoapplication.util.Resource
import javax.inject.Inject

//kripto para liste verilerini almak için kullanılan bir iş mantığı sınıfıdır.
//uygulamanın iş mantığı (business logic) katmanını temsil eder ve repository katmanından veri almayı sağlar.

class GetCryptoListUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun execute() : Resource<CryptoMetaDataResponse> {
        return homeRepository.getCryptoMetaData()
    }
}

//Bu yapı, temiz mimari prensiplerine göre UI ile data katmanını ayırır ve her katmanı sorumluluklarına uygun şekilde düzenler.