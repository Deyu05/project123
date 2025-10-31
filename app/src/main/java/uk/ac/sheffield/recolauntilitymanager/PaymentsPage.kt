package uk.ac.sheffield.recolauntilitymanager

import MyList
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.NavBar
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.ScreenName
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.SmallAppBar

@Preview
@Composable
fun PaymentPage() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SmallAppBar(ScreenName.PAYMENTS) },
        bottomBar = { NavBar(ScreenName.PAYMENTS) {} }
    ) { innerPadding ->
        MyList(innerPadding)
    }
}