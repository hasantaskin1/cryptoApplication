package com.hasantaskin.cryptoapplication.ui.dependecyinjection

import com.hasantaskin.cryptoapplication.BuildConfig
import com.hasantaskin.cryptoapplication.data.network.APIservice
import com.hasantaskin.cryptoapplication.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//Hiltler module ile çalışır
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton //Eğer uygulama debug modundaysa, tüm ağ talepleri ve yanıtları loglanır. Aksi halde loglama yapılmaz.
    @Provides
    fun provideHttpLoggerInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        else httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE

       return httpLoggingInterceptor
    //Eğer uygulama debug modundaysa, tüm ağ talepleri ve yanıtları loglanır. Aksi halde loglama yapılmaz.
    }

    @Singleton
    @Provides
    fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder().readTimeout(60,TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
            .connectTimeout(60,TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
        //bağlantı süresi ve okuma zaman aşımı için 60 saniye olarak belirlenmiştir


    }

    @Singleton
    @Provides
    fun provideConverteFactory() : GsonConverterFactory{
        return GsonConverterFactory.create()
    //Retrofit için JSON verilerini Gson kullanarak Java/Kotlin nesnelerine dönüştürme işini yapar.
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit{ //Retrofit, HTTP isteklerini yönetmek için kullanılan bir kütüphanedir. Burada baseUrl ve client ayarları yapılır.
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)//JSON verilerinin dönüştürülmesi sağlanır.
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) : APIservice {
        return retrofit.create(APIservice::class.java) //Retrofit'in sağladığı API interface'inin bir örneğini döndürür.
    }

}