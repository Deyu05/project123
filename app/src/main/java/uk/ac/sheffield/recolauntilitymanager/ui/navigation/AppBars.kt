package uk.ac.sheffield.recolauntilitymanager.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SmallAppBarPreview() {
    SmallAppBar(ScreenName.default())
}

/**
 * Displays a Material3 'small app bar' at the top of the screen.
 * Sets the title to the current navigation screen, shows a back
 * button and a set of action buttons depending on the navigation screen.
 * @param currentScreenName [ScreenName] The navigation screen the app is currently on
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallAppBar(currentScreenName : ScreenName) {
    TopAppBar(
        // back button
        navigationIcon = {
            IconButton(
                // TODO make the back button work
                onClick = {}
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack,
                    "Back icon")
            } },

        // title of the current page
        title = { Text(currentScreenName.toString()) },

        // decide which, if any, action buttons to add
        actions = { AppBarActionButtons(currentScreenName) }
    )
}

/**
 * Decides which action buttons are needed on the app bar
 * and draws them, depending on the current navigation screen.
 * @param currentScreenName [ScreenName] The navigation screen the app is currently on
 */
@Composable
fun AppBarActionButtons(currentScreenName : ScreenName) {
    var icons : List<ImageVector> = emptyList()
    var iconDescription : List<String> = emptyList()

    // decide which buttons, if any, are needed for each screen
    when (currentScreenName) {
        ScreenName.PROPERTIES, ScreenName.SUPPLIERS -> {
            icons = listOf(Icons.Filled.SwapVert, Icons.Filled.FilterList, Icons.Filled.Add)
            iconDescription = listOf("Sort by", "Filter", "Add")
        }

        ScreenName.PAYMENTS -> {
            icons = listOf(Icons.Filled.SwapVert, Icons.Filled.FilterList)
            iconDescription = listOf("Sort by", "Filter",)
        }
        else -> {}
    }

    // draw all buttons in a loop
    icons.forEachIndexed { index, icon ->
        IconButton(onClick = {}) { // TODO make the buttons functional
            Icon(
                imageVector = icon,
                contentDescription = iconDescription[index]
            )
        }
    }
}
