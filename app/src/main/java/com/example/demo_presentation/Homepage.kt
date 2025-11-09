package com.example.demo_presentation

import kotlin.OptIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToLabeledIcon: () -> Unit = {},
    onNavigateToGroupedCard: () -> Unit = {},
    onNavigateToComplexGesture: () -> Unit = {},
    onNavigateToTouchTargetAndContrast: () -> Unit = {},
    onNavigateToFormWithError: () -> Unit = {},
    onNavigateToAccessibleDialog: () -> Unit = {}
){
    Scaffold(
        topBar = { TopAppBar(title = { Text("Home") }) }
    ){ contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Semantics")
            Button(onClick = onNavigateToLabeledIcon) {
                Text("Labeled Icon Demo")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToGroupedCard) {
                Text("Grouped Card Demo")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text("Interactions")
            Button(onClick = onNavigateToComplexGesture) {
                Text("Complex Gesture Demo")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToTouchTargetAndContrast) {
                Text("Touch Target & Contrast Demo")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("User and Error Handling")
            Button(onClick = onNavigateToFormWithError) {
                Text("Form with Error Demo")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToAccessibleDialog) {
                Text("Accessible Dialog Demo")
            }


        }
    }
}