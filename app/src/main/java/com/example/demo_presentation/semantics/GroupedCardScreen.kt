package com.example.demo_presentation.semantics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun GroupedCardScreen() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            // clear children semantics so TalkBack reads a single, coherent announcement
            .semantics(mergeDescendants = true) {}
    ) {
        Row(Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Icon(Icons.Default.DateRange, contentDescription = "Meeting Icon")
            Column {
                Text("Meeting with product team", fontWeight = FontWeight.SemiBold)
                Text("Today • 15:00–16:00 • Room A")
                Text("Tap for details")
            }
        }
    }
}