package com.hasantaskin.cryptoapplication.data.model.metadata

import com.google.gson.annotations.SerializedName

//Bu sınıf, döviz bazlı piyasa verilerini daha derinlemesine
//incelemek için meta verilerini bir arada tutar

data class CryptoMetaDataQuote(
    @SerializedName("USD")
    val quoteDollar: CryptoMetaDataDollar
)