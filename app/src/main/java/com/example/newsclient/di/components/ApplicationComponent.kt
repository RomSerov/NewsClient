package com.example.newsclient.di.components

import android.content.Context
import com.example.newsclient.ViewModelFactory
import com.example.newsclient.di.modules.DataModule
import com.example.newsclient.di.modules.ViewModelModule
import com.example.newsclient.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun getViewModelFactory(): ViewModelFactory

    fun getCommentsScreenComponentFactory(): CommentsScreenComponent.Factory

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}