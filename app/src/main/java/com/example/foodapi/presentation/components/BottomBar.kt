package com.example.foodapi.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodapi.R

@Composable
fun BottomBar(
    navController: NavController
) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp, backgroundColor = colorResource(id = R.color.topbar)) {

        BottomNavigationItem(
            icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            label = { Text(text = "Home") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
                navController.navigate("main")
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Favorite,"")
        },
            label = { Text(text = "Favorite") },
            selected = (selectedIndex.value == 1),
            onClick = {
                navController.navigate("favorites")
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person,"")
        },
            label = { Text(text = "Profile") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })
    }
}