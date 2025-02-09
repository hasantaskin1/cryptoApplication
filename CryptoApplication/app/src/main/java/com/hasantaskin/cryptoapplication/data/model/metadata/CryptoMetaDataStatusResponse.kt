package com.hasantaskin.cryptoapplication.data.model.metadata

import com.google.gson.annotations.SerializedName

// Bu sınıf, API'den dönen yanıtın genel durumu ve yanıtla ilgili bilgileri içeren
// bir yapıdadır. Bu bilgiler, API kullanım limitlerini,
// işlem süresini, hata durumlarını ve daha fazlasını içerir.

data class CryptoMetaDataStatusResponse(
    @SerializedName("credit_count")
    val statusCreditCount: Int,
    @SerializedName("elapsed")
    val statusElapsed: Int,
    @SerializedName("error_code")
    val statusErrorCode: Int,
    @SerializedName("error_message")
    val statusErrorMessage: Any,
    @SerializedName("notice")
    val statusNotice: Any,
    @SerializedName("timestamp")
    val statusTimestamp: String,
    @SerializedName("total_count")
    val statusTotalCount: Int
)