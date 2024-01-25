package com.example.newsclient.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsclient.domain.model.FeedPost

class NavigationState(val navHostController: NavHostController) {

    fun navigateTo(route: String) {
        navHostController.navigate(
            route = route,
            builder = {
                popUpTo(
                    id = navHostController.graph.findStartDestination().id,
                    popUpToBuilder = { saveState = true }
                )
                launchSingleTop = true
                restoreState = true
            }
        )
    }

    fun navigateToComments(feedPost: FeedPost) {
        navHostController.navigate(route = Screen.Comments.getRouteWithArgs(feedPost)) // comments/15
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController = navHostController)
    }
}