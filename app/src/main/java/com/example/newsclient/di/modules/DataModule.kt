package com.example.newsclient.di.modules

import android.content.Context
import com.example.newsclient.data.remote.ApiFactory
import com.example.newsclient.data.remote.ApiService
import com.example.newsclient.data.repository.NewsFeedRepositoryImpl
import com.example.newsclient.di.scope.ApplicationScope
import com.example.newsclient.domain.repository.NewsFeedRepository
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: NewsFeedRepositoryImpl): NewsFeedRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @ApplicationScope
        @Provides
        fun provideVkStorage(context: Context): VKPreferencesKeyValueStorage {
            return VKPreferencesKeyValueStorage(context)
        }
    }
}