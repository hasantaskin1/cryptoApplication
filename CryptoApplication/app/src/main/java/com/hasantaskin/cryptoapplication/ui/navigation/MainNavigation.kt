package com.hasantaskin.cryptoapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hasantaskin.cryptoapplication.ui.screen.CryptoDetailScreen
import com.hasantaskin.cryptoapplication.ui.screen.CryptoListScreen

//fonksiyon, iki ekran arasında geçişi yönetir: CryptoListScreen ve CryptoDetailScreen.

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "crypto_list_screen") {
        composable("crypto_list_screen") {
            CryptoListScreen(navController = navController)//uygulamanın ilk açıldığında hangi ekranın görüntüleneceği belirlenir.
        }
        composable(
            route = "crypto_detail_screen/{cryptoID}",
            arguments = listOf(navArgument("cryptoID") {type = NavType.StringType})
        ) {
            val cryptoID = remember { it.arguments?.getString("cryptoID") }
            //Bu ekran, cryptoID parametresini URL parametresi olarak alır. Bu parametre, belirli bir kripto para biriminin detaylarını göstermek için kullanılır

            CryptoDetailScreen(cryptoID = cryptoID ?: "")
        }
    }
}