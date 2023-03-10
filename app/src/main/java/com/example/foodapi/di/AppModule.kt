package com.example.foodapi.di

import com.example.foodapi.common.Constants.BASE_URL
import com.example.foodapi.data.remote.FoodApi
import com.example.foodapi.data.repository.RepositoryImpl
import com.example.foodapi.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): FoodApi{
        return retrofit.create(FoodApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: FoodApi): Repository = RepositoryImpl(api)

}