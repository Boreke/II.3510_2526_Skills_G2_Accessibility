package com.example.demo_presentation.semantics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun UnlabeledVsLabeledIconScreen() {
    Row(Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(24.dp)) {
        // ❌ Problem: TalkBack says "Unlabeled button"
        IconButton(onClick = { /* ... */ }) {
            Icon(Icons.Default.Search, contentDescription = null) // <-- bad: null
        }

        // ✅ Fix: give it a meaningful label
        IconButton(
            onClick = { /* ... */ },
            modifier = Modifier.semantics { contentDescription = "Search products" }
        ) {
            Icon(Icons.Default.Search, contentDescription = "search")
        }
    }
}