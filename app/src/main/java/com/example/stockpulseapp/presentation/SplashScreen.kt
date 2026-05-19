package com.example.stockpulseapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.stockpulseapp.security.SecureTokenManager
import com.example.stockpulseapp.ui.theme.StockPulseAppTheme

import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
        secureTokenManager: SecureTokenManager,
    navController: NavHostController
) {

    LaunchedEffect(Unit) {

        delay(1000) // optional splash delay

        if (secureTokenManager.isLoggedIn()) {

            navController.navigate("home") {
                popUpTo("splash") { inclusive = true }
            }
        } else {
            navController.navigate("login") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Loading...")
    }
}

@Preview(showBackground = true)
@Composable
fun showSplash() {
    StockPulseAppTheme () {
        showSplash()
    }
}