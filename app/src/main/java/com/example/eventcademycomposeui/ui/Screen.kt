package com.example.eventcademycomposeui.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.eventcademycomposeui.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector){
    object Home: Screen("Profile", R.string.home, Icons.Outlined.Home)
    object Favorite: Screen("Profile", R.string.favorite, Icons.Outlined.Favorite)
    object Notification: Screen("Profile", R.string.notification, Icons.Outlined.Notifications)
    object Profile: Screen("Profile", R.string.profile, Icons.Outlined.Person)
}
