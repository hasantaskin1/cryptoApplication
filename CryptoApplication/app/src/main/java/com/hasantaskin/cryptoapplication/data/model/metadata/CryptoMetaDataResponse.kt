package com.hasantaskin.cryptoapplication.data.model.metadata

import com.google.gson.annotations.SerializedName

//Bu sınıf gerekli meta verileri liste halinde toplar

data class CryptoMetaDataResponse(
    @SerializedName("data")
    val `data`: List<CryptoMetaData>,
    @SerializedName("status")
    val status: CryptoMetaDataStatusResponse
)