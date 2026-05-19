package com.example.stockpulseapp.presentation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stockpulseapp.presentation.Profile.EditProfileScreen
import com.example.stockpulseapp.presentation.dashbaord.presenting.HomeScreen
import com.example.stockpulseapp.presentation.explore.presenting.ExploreScreen
import com.example.stockpulseapp.ui.theme.StockPulseAppTheme


data class BottomItem(
    val label: String,
    val icon: ImageVector
)

@Composable
fun BottomNAvMainScreen() {

    var selectedIndex by remember { mutableStateOf(0) }

    val items = listOf(
        BottomItem("Home", Icons.Default.Home),
        BottomItem("Explore", Icons.Default.Search),
        BottomItem("Profile", Icons.Default.Person)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 👇 Screen Content
            when (selectedIndex) {
                0 -> HomeScreen()
            1 -> ExploreScreen()
            2 -> EditProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowBottomNav(){
    StockPulseAppTheme () {
        BottomNAvMainScreen()
    }
}