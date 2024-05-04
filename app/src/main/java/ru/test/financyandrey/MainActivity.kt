package ru.test.financyandrey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.test.financyandrey.accounts.ui.AccountsScreen
import ru.test.financyandrey.accounts.ui.AddAccountScreen
import ru.test.financyandrey.categories_screen.ui.CategoriesScreen
import ru.test.financyandrey.ui.theme.FinancyAndreyTheme

enum class Route {
    AddCategories,
    Account,
    AddAccount
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinancyAndreyTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = Route.Account.name){
                        composable(Route.Account.name){
                            AccountsScreen(addAccount = { navController.navigate(Route.AddAccount.name) })
                        }

                        composable(Route.AddAccount.name){
                            AddAccountScreen(onBack = navController::popBackStack)
                        }

                        composable(Route.AddCategories.name){
                            CategoriesScreen()
                        }
                    }
                }
            }
        }
    }
}

