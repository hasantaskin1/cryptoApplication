package com.hasantaskin.cryptoapplication.data.network

import com.hasantaskin.cryptoapplication.data.model.detail.CryptoDetailResponse
import com.hasantaskin.cryptoapplication.data.model.metadata.CryptoMetaDataResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

//Retrofit kullanarak kripto para verilerini almak için tanımlanmış API servislerinin
//arayüzüdür. aslında kemik yapıyı oluşturur

interface APIservice {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getCryptoMetaData(
        @Header("X-CMC_PRO_API_KEY") apiKey: String,
        @Query("limit") limit: String
    ): CryptoMetaDataResponse

    @GET("v2/cryptocurrency/info")
    suspend fun getCryptoDetailData(
        @Header("X-CMC_PRO_API_KEY") apiKey: String,
        @Query("symbol") cryptoID: String
    ) : CryptoDetailResponse

}