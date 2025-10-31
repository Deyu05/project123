package uk.ac.sheffield.recolauntilitymanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.*
import uk.ac.sheffield.recolauntilitymanager.ui.theme.ReColaUntilityManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReColaUntilityManagerTheme {
                // Stores the current screen the app is on
                var currentScreenName : ScreenName by rememberSaveable {
                    mutableStateOf(ScreenName.default()) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { SmallAppBar(currentScreenName) },
                    bottomBar = { NavBar(currentScreenName) { currentScreenName = it } }
                ) { innerPadding ->
                    Text(
                        text = "The current screen is the $currentScreenName screen",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReColaUntilityManagerTheme {
        Greeting("Android")
    }
}