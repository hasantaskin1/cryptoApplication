package com.hasantaskin.cryptoapplication.ui.dependecyinjection

import com.hasantaskin.cryptoapplication.data.network.APIservice
import com.hasantaskin.cryptoapplication.data.repository.DetailRepositoryImplementation
import com.hasantaskin.cryptoapplication.data.repository.HomeRepositoryImplementation
import com.hasantaskin.cryptoapplication.domain.repository.DetailRepository
import com.hasantaskin.cryptoapplication.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(
        apiService: APIservice //apiService parametresi, Retrofit ile sağlanan APIservice nesnesini içerir.
    ) : HomeRepository{
        return HomeRepositoryImplementation(apiService)
        //APIservice ile ağ isteklerini yapacak bir HomeRepositoryImplementation nesnesi ile implement edilir.
    }

    @Singleton
    @Provides
    fun provideDetailRepository(
        apiService: APIservice
    ) : DetailRepository {
        return DetailRepositoryImplementation(apiService)
        //APIservice ile ağ isteklerini yapacak bir DetailRepositoryImplementation nesnesi ile implement edilir.
    }
}