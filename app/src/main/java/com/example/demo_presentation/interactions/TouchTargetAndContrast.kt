package com.example.demo_presentation.interactions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TouchTargetAndContrast() {
    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {

        // ❌ Small hitbox, low contrast text (example)
        Text("Low contrast?", fontSize = 12.sp) // pretend foreground vs background too close
        Box(
            modifier = Modifier
                .size(24.dp) // too small
                .background(Color.LightGray)
                .clickable { /* ... */ }
        )

        // ✅ Minimum 48x48dp touch target + clear text contrast
        Text(
            "Clear contrast",
            style = MaterialTheme.typography.bodyLarge // uses theme with adequate contrast
        )
        Box(
            modifier = Modifier
                .sizeIn(minWidth = 48.dp, minHeight = 48.dp)
                .padding(8.dp) // visual size can differ, hitbox remains large
                .background(Color.Gray)
                .clickable { /* ... */ }
        ) {
            Text("Tap", modifier = Modifier.align(Alignment.Center))
        }
    }
}
