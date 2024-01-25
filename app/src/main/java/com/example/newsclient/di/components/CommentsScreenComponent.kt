package com.example.newsclient.di.components

import com.example.newsclient.ViewModelFactory
import com.example.newsclient.di.modules.CommentsViewModelModule
import com.example.newsclient.domain.model.FeedPost
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [CommentsViewModelModule::class])
interface CommentsScreenComponent {

    fun getViewModelFactory(): ViewModelFactory

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance feedPost: FeedPost
        ): CommentsScreenComponent
    }
}