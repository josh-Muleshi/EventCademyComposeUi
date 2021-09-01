package com.example.eventcademycomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.eventcademycomposeui.ui.HomeScreen
import com.example.eventcademycomposeui.ui.Screen
import com.example.eventcademycomposeui.ui.theme.EventCademyComposeUiTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventCademyComposeUiTheme {
                HomeScreen()
            }
        }
    }
}
@Composable
fun MyBottomNavigationBar(){
    val navController = rememberNavController()
    val items = listOf(Screen.Home, Screen.Favorite, Screen.Notification, Screen.Profile)
    BottomNavigation {
        val currentBasicStateEntry by navController.currentBackStackEntryAsState()
        val currentRoute = currentBasicStateEntry?.arguments?.getString("route")
        items.forEach { screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo = navController.graph.startDestinationId
                        launchSingleTop = true
                    }

                },
                icon = { Icon(screen.icon, contentDescription = stringResource(screen.resourceId)) }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    EventCademyComposeUiTheme {
        HomeScreen()
    }
}