package com.hasantaskin.cryptoapplication.domain.repository

import com.hasantaskin.cryptoapplication.data.model.detail.CryptoDetailResponse
import com.hasantaskin.cryptoapplication.util.Constants
import com.hasantaskin.cryptoapplication.util.Resource

//kripto para detaylarını almak için gerekli olan metodun şablonunu sağlar.
//getCryptoDetailData metodu, API'den kripto para detaylarını alır ve sonuçları Resource sınıfı ile yönetir.

interface DetailRepository {

    suspend fun getCryptoDetailData(
        apiKey: String = Constants.API_KEY,
        cryptoID: String
    ) : Resource<CryptoDetailResponse>
}