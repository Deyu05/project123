package uk.ac.sheffield.recolauntilitymanager.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Stores the title, icon and the [ScreenName] of an
 * item on the main navigation bar
 * @param title [String] The title of the navigation page
 * @param icon [ImageVector] The icon to use, normally a material 3 icon from the
 * [Icons] package
 * @param screenName [ScreenName] The screen that this navigation item represents
 */
data class NavigationItem(
    val title : String,
    val icon : ImageVector,
    val screenName : ScreenName
)
