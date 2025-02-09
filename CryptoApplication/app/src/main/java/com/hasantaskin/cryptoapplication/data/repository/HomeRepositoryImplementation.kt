package com.hasantaskin.cryptoapplication.data.repository

import com.hasantaskin.cryptoapplication.data.model.metadata.CryptoMetaDataResponse
import com.hasantaskin.cryptoapplication.data.network.APIservice
import com.hasantaskin.cryptoapplication.domain.repository.HomeRepository
import com.hasantaskin.cryptoapplication.util.Resource
import javax.inject.Inject

//API servisi ile etkileşime girerek gerekli veriyi çeker ve sonuçları işleyerek bir Resource nesnesi içinde döner.
//Bu yapı, uygulamanın hata yönetimini ve başarılı veri akışını düzenler. -> Clear Architectur

class HomeRepositoryImplementation @Inject constructor(
    private val apiService : APIservice
) : HomeRepository {
    override suspend fun getCryptoMetaData(
        apiKey: String,
        limit: String
    ): Resource<CryptoMetaDataResponse> {
        val response = try {
            apiService.getCryptoMetaData(apiKey, limit)
        } catch (e: Exception) {
            return Resource.Error("Something went wrong!")
        }
        return Resource.Success(response)
    }
}