package com.example.eventcademycomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.eventcademycomposeui.ui.*
import com.example.eventcademycomposeui.ui.theme.EventCademyComposeUiTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventCademyComposeUiTheme {
                MyBottomNavigationBar()
            }
        }
    }
}
@Composable
fun MyBottomNavigationBar(){
    val items = listOf(Screen.Home, Screen.Favorite, Screen.Notification, Screen.Profile)
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = stringResource(screen.resourceId))},
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screen.Profile.route, Modifier.padding(innerPadding)) {
            composable(Screen.Home.route) { Home(navController) }
            composable(Screen.Favorite.route) { Favorite(navController) }
            composable(Screen.Notification.route) { Notification(navController) }
            composable(Screen.Profile.route) { Profile(navController) }
        }
    }
}

@Composable
fun Home(navController: NavHostController) {
    HomeScreen()
}

@Composable
fun Favorite(navController: NavHostController) {
    FavoriteScreen()
}

@Composable
fun Notification(navController: NavHostController) {
    NotificationScreen()
}

@Composable
fun Profile(navController: NavHostController) {
    ProfileScreen()
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    EventCademyComposeUiTheme {
        MyBottomNavigationBar()
    }
}