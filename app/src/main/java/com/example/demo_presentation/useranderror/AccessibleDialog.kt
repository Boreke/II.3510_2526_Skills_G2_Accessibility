package com.example.demo_presentation.useranderror

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp

@Composable
fun AccessibleDialogScreen() {
    var show by remember { mutableStateOf(false) }

    Button(onClick = { show = true }, Modifier.padding(16.dp)) { Text("Open dialog") }

    if (show) {
        AlertDialog(
            onDismissRequest = { show = false }, // ✅ Back press & outside tap dismiss
            confirmButton = {
                TextButton(onClick = { show = false }) { Text("OK") }
            },
            dismissButton = {
                TextButton(onClick = { show = false }) { Text("Cancel") }
            },
            title = { Text("Delete item?") },
            text = { Text("This action cannot be undone.") }
        )
    }
}
