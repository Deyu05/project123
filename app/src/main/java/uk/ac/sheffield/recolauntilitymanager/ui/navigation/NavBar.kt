package uk.ac.sheffield.recolauntilitymanager.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.HolidayVillage
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun NavBarPreview() {
    // fluff variable to store current screen
    var currentScreenId = ScreenName.PROPERTIES
    NavBar(currentScreenId) { currentScreenId = it }
}

/**
 * Displays the main navigation bar at the bottom of the screen based and updates the
 * variable storing the current navigation page. Uses the default material 3 design.
 * @param currentScreenName [ScreenName] The hoisted variable storing the current navigation page
 * @param updateSelected Function to update the hoisted currentScreenName globally
 */
@Composable
fun NavBar(currentScreenName : ScreenName, updateSelected : (ScreenName) -> Unit) {
    // list of navigation items
    val navItems = listOf(
        NavigationItem("Properties", Icons.Filled.HolidayVillage, ScreenName.PROPERTIES),
        NavigationItem("Map", Icons.Filled.Map, ScreenName.MAP),
        NavigationItem("Overdue", Icons.Filled.Person, ScreenName.PAYMENTS),
        NavigationItem("Suppliers", Icons.Filled.Bolt, ScreenName.SUPPLIERS)
    )

    // draw the navigation bar and items using a for loop
    NavigationBar {
        navItems.forEach{ navItem ->
            NavigationBarItem(
                selected = currentScreenName == navItem.screenName,
                icon = @Composable {
                    Icon(imageVector = navItem.icon,
                        contentDescription = "${navItem.title} icon"
                    )},
                label = @Composable { Text(navItem.title) },
                onClick = {
                    // update variable saying the current navigation page
                    updateSelected(navItem.screenName)
                }
            )
        }
    }
}
