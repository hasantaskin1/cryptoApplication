package com.hasantaskin.cryptoapplication.domain.repository

import com.hasantaskin.cryptoapplication.data.model.metadata.CryptoMetaDataResponse
import com.hasantaskin.cryptoapplication.util.Constants
import com.hasantaskin.cryptoapplication.util.Resource

//kripto para meta verilerini almak için gerekli olan metodun şablonunu sağlar.
//getCryptoMetaData metodu, API'den kripto para meta verilerini alır ve sonuçları Resource sınıfı ile yönetir.

interface HomeRepository {

    suspend fun getCryptoMetaData(
        apiKey: String = Constants.API_KEY,
        limit: String = Constants.LIMIT
    ): Resource<CryptoMetaDataResponse>
}