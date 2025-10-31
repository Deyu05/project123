package uk.ac.sheffield.recolauntilitymanager

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.NavBar
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.ScreenName
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.SmallAppBar

@Preview
@Composable
fun PropertyPage() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SmallAppBar(ScreenName.default()) },
        bottomBar = { NavBar(ScreenName.default(), {}) }
    ) { innerPadding ->
        MyGrid(innerPadding)
    }
}