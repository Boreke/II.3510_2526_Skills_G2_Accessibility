package com.example.demo_presentation.interactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComplexGestureAlternative() {
    var count by remember { mutableStateOf(0) }

    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        // ❌ Imagine a "shake to undo" exists (not accessible)
        Text("Count: $count")
        // ✅ Provide a simple on-screen button as an alternative
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { count++ }) { Text("Increment") }
            OutlinedButton(onClick = { count = 0 }) { Text("Undo") }
        }
    }
}

