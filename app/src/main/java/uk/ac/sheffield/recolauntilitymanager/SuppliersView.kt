package uk.ac.sheffield.recolauntilitymanager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_3
import androidx.compose.ui.tooling.preview.Preview
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.NavBar
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.ScreenName
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.SmallAppBar
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Preview(device = PIXEL_3)
@Composable
fun SuppliersViewPreview() {
    val currentScreenName = ScreenName.SUPPLIERS

    // show the top app & nav bars in the preview
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SmallAppBar(currentScreenName) },
        bottomBar = { NavBar(currentScreenName) { } }
    ) { innerPadding ->
        // example list of utility suppliers
        val utilitySuppliers = listOf(UtilitySupplierEntity(UtilityType.ELECTRICITY, "British Gas", "customers@britishgas.co.uk"),
            UtilitySupplierEntity(UtilityType.ELECTRICITY, "Octopus Energy", "customers@octopus.co.uk"),
            UtilitySupplierEntity(UtilityType.GAS, "British Gas", "gas_customers@britishgas.co.uk"),
            UtilitySupplierEntity(UtilityType.GAS, "Octopus Energy", "customers@octopus.co.uk"),
            UtilitySupplierEntity(UtilityType.WATER, "Yorkshire Water", "customerenquires@yorkshirewater.co.uk"),
            UtilitySupplierEntity(UtilityType.BROADBAND, "Virgin Media", "enquires@virginmedia.co.uk"),
            UtilitySupplierEntity(UtilityType.BROADBAND, "BT", "help@bt.com")
        )
        SuppliersView(innerPadding, utilitySuppliers)
    }
}

/**
 * Displays the Suppliers page. Lists each type of utility provider as a heading
 * with utility providers of that type listed below. Draws an edit button
 * to edit the supplier.
 * @param paddingValues Padding values to prevent collision with the app/nav bars
 * @param utilitySuppliers [List] All utility suppliers stored on the system
 */
@Composable
fun SuppliersView(paddingValues: PaddingValues, utilitySuppliers : List<UtilitySupplierEntity>) {
    // list of icons that represent each utility
    val utilityIcons = mutableListOf(Icons.Filled.Bolt, Icons.Filled.LocalFireDepartment,
        Icons.Filled.WaterDrop, Icons.Filled.Wifi)

    LazyColumn(
        modifier = Modifier.padding(8.dp, paddingValues.calculateTopPadding(),
            16.dp, paddingValues.calculateBottomPadding())
    ) {
        // show each utility type as a heading
        items(UtilityType.entries) { utilityType ->
            Row() {
                Icon(utilityIcons[0], "utility icon")
                Spacer(Modifier.padding(start = 8.dp))
                Text(utilityType.toString(), style = MaterialTheme.typography.titleLarge)

                // pop the first icon from the list
                utilityIcons.removeAt(0)
            }
            // list all utility suppliers of this type below it
            utilitySuppliers.filter { it.type == utilityType}.forEach{ supplier ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 48.dp)
                ) {
                    // utility supplier and contact details on the left
                    Column {
                        Text(supplier.name, style = MaterialTheme.typography.titleMedium)
                        Text(supplier.contactDetails)
                    }

                    // edit icon on the right side
                    Spacer(Modifier.weight(1f))
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Edit, "Edit icon")
                    }
                }
            }
        }
    }
}