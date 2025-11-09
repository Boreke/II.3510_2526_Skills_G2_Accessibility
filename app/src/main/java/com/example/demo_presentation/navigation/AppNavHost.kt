// kotlin
package com.example.demo_presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo_presentation.HomeScreen
import com.example.demo_presentation.interactions.ComplexGestureAlternative
import com.example.demo_presentation.interactions.TouchTargetAndContrast
import com.example.demo_presentation.semantics.GroupedCardScreen
import com.example.demo_presentation.semantics.UnlabeledVsLabeledIconScreen
import com.example.demo_presentation.useranderror.AccessibleDialogScreen
import com.example.demo_presentation.useranderror.FormWithError

@Composable
fun AppNavHost(startDestination: String = Routes.Home, modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.fillMaxSize()
    ) {
        composable(Routes.Home) {
            HomeScreen(
                onNavigateToLabeledIcon = {navController.navigate(Routes.LabeledIcon)},
                onNavigateToGroupedCard = {navController.navigate(Routes.GroupedCard)},
                onNavigateToComplexGesture = {navController.navigate(Routes.ComplexGesture)},
                onNavigateToTouchTargetAndContrast = {navController.navigate(Routes.TouchTargetAndContrast)},
                onNavigateToFormWithError = {navController.navigate(Routes.FormWithError)},
                onNavigateToAccessibleDialog = {navController.navigate(Routes.AccessibleDialog)}
            )
        }

        composable(Routes.LabeledIcon){
            UnlabeledVsLabeledIconScreen()
        }

        composable(Routes.GroupedCard){
            GroupedCardScreen()
        }

        composable(Routes.ComplexGesture){
            ComplexGestureAlternative()
        }

        composable(Routes.TouchTargetAndContrast){
            TouchTargetAndContrast()
        }

        composable(Routes.AccessibleDialog){
            AccessibleDialogScreen()
        }

        composable(Routes.FormWithError){
            FormWithError()
        }


    }
}
