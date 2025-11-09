package com.example.demo_presentation.useranderror

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.LiveRegionMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormWithError() {
    var email by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Email")

        TextField(
            value = email,
            onValueChange = { email = it; error = null },
            isError = error != null,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                if (error != null) Text(error!!)
                else Text("We’ll send a confirmation link.")
            },
            placeholder = { Text("name@example.com") }
        )

        Button(onClick = {
            error = if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
                "Please enter a valid email address."
            else null
        }) { Text("Continue") }

        // Announce the error politely when it appears
        if (error != null) {
            Text(
                error!!,
                modifier = Modifier.semantics {
                    liveRegion = LiveRegionMode.Assertive
                }
            )
        }
    }
}
