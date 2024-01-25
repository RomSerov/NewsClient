package com.example.newsclient.di.modules

import androidx.lifecycle.ViewModel
import com.example.newsclient.di.annotations.ViewModelKey
import com.example.newsclient.presentation.comments.CommentsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CommentsViewModelModule {

    @IntoMap
    @ViewModelKey(CommentsViewModel::class)
    @Binds
    fun bindCommentsViewModel(viewModel: CommentsViewModel): ViewModel
}