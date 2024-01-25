package com.example.newsclient.domain.usecase

import com.example.newsclient.domain.model.FeedPost
import com.example.newsclient.domain.model.PostComment
import com.example.newsclient.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
    private val repository: NewsFeedRepository
) {

    operator fun invoke(feedPost: FeedPost): StateFlow<List<PostComment>> {
        return repository.getComments(feedPost)
    }
}