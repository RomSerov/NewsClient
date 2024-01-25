package com.example.newsclient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.newsclient.domain.model.FeedPost

fun NavGraphBuilder.homeScreenNavGraph(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit
) {
    navigation(
        startDestination = Screen.NewsFeed.route,
        route = Screen.Home.route
    ) {
        composable(
            route = Screen.NewsFeed.route,
            content = {
                newsFeedScreenContent()
            }
        )

        composable(
            route = Screen.Comments.route,
            arguments = listOf(
                navArgument(
                    name = Screen.KEY_FEED_POST,
                    builder = {
                        type = FeedPost.NavigationType
                    }
                )
            ),
            content = {
                val feedPost = it.arguments?.getParcelable<FeedPost>(Screen.KEY_FEED_POST) ?: throw RuntimeException("Args is null") //comments/{feed_post_id}
                commentsScreenContent(feedPost)
            }
        )
    }
}