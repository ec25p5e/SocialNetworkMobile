package com.ec25p5e.socialnetworkmobile.core.util

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object MainFeedScreen: Screen("main_feed_screen")
    object ChatScreen : Screen("chat_screen")
    object ActivityScreen : Screen("activity_screen")
    object CreatePostScreen : Screen("create_post_screen")
    object ProfileScreen : Screen("profile_screen")
}