package com.hasantaskin.cryptoapplication.data.repository

import com.hasantaskin.cryptoapplication.data.model.detail.CryptoDetailResponse
import com.hasantaskin.cryptoapplication.data.network.APIservice
import com.hasantaskin.cryptoapplication.domain.repository.DetailRepository
import com.hasantaskin.cryptoapplication.util.Resource
import javax.inject.Inject

//API servisi ile etkileşime girerek gerekli veriyi çeker ve sonuçları işleyerek bir Resource nesnesi içinde döner.
// Bu yapı, uygulamanın hata yönetimini ve başarılı veri akışını düzenler. -> Clear Architectur

class DetailRepositoryImplementation@Inject constructor(
    private val apiService: APIservice
) : DetailRepository{
    override suspend fun getCryptoDetailData(
        apiKey: String,
        cryptoID: String
    ): Resource<CryptoDetailResponse> {
        val response = try{
            apiService.getCryptoDetailData(apiKey,cryptoID)
        } catch (e: Exception){
            return Resource.Error("Something went wrong!")
        }
        return  Resource.Success(response)
    }
}