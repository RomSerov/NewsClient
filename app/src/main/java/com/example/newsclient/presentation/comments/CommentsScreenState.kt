package com.example.newsclient.presentation.comments

import com.example.newsclient.domain.model.FeedPost
import com.example.newsclient.domain.model.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}