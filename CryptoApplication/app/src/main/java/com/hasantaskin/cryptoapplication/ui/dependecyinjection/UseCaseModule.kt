package com.hasantaskin.cryptoapplication.ui.dependecyinjection

import com.hasantaskin.cryptoapplication.domain.repository.DetailRepository
import com.hasantaskin.cryptoapplication.domain.repository.HomeRepository
import com.hasantaskin.cryptoapplication.domain.usecase.GetCryptoDetailUseCase
import com.hasantaskin.cryptoapplication.domain.usecase.GetCryptoListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetCryptoListUseCase(
        homeRepository: HomeRepository //Bu repository, kripto para listesini almak için kullanılır.
    ) : GetCryptoListUseCase{
        return GetCryptoListUseCase(homeRepository)
    }

    @Singleton
    @Provides
    fun provideGetCryptoDetailUseCase(
        detailRepository: DetailRepository //Bu repository, belirli bir kripto paranın detaylarını almak için kullanılır.
    ) : GetCryptoDetailUseCase {
        return GetCryptoDetailUseCase(detailRepository)
    }
}