package com.hasantaskin.cryptoapplication.domain.usecase

import com.hasantaskin.cryptoapplication.data.model.detail.CryptoDetailResponse
import com.hasantaskin.cryptoapplication.domain.repository.DetailRepository
import com.hasantaskin.cryptoapplication.util.Resource
import javax.inject.Inject

//kripto para detay verilerini almak için kullanılan bir iş mantığı sınıfıdır.
// Bu sınıf, uygulamanın iş mantığı (business logic) katmanını temsil eder ve repository katmanından veri almayı sağlar.

class GetCryptoDetailUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    suspend fun execute(
        cryptoID: String
    ) : Resource<CryptoDetailResponse>{
        return detailRepository.getCryptoDetailData(cryptoID = cryptoID)
    }
}