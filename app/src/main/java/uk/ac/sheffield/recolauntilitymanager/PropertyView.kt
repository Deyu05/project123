package uk.ac.sheffield.recolauntilitymanager

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices.PIXEL_3
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.NavBar
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.ScreenName
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.SmallAppBar
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment

/**
 * Previews the [PropertyViewScreen] page that shows details about a property.
 * Passes in a test property and test tenants/bills
 */
@Preview(showBackground = true, device = PIXEL_3)
@Composable
fun PropertyViewScreenPreview() {
    val currentScreenName = ScreenName.VIEW_PROPERTY

    // show the top app & nav bars in the preview
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SmallAppBar(currentScreenName) },
        bottomBar = { NavBar(currentScreenName) { } }
    ) { innerPadding ->
        // example house with two tenants
        val testHouse = PropertyEntity("10 Downing Street", "London, SW1A 2AA", R.drawable.downingstreet, 5, "", "Go beyond the large metal gates and then turn left")
        val tenants = listOf(TenantEntity("Margaret Thatcher", "maggiethatch@gmail.com", "", testHouse),
            TenantEntity("Boris Johnson", "bj@gmail.com", "", testHouse))
        PropertyViewScreen(testHouse, innerPadding, tenants)
    }
}

/**
 * Main function to show the 'View Property' screen. Shows details about
 * the property, including a picture, a live map showing the property's
 * location, and then secondary tabs displaying either a list of tenants
 * or a list of bills
 * @param property [PropertyEntity] The property to display, from the database
 * @param innerPadding Top/bottom padding values so the content clears the app/nav bars
 * @param tenants [List] List of tenants who live at the above property. TODO calculate this from the property
 */
@Composable
fun PropertyViewScreen(property : PropertyEntity, innerPadding : PaddingValues, tenants: List<TenantEntity>) {
    // main column for the whole page
    Column(
        modifier = Modifier.padding(top = innerPadding.calculateTopPadding(),
            bottom = innerPadding.calculateBottomPadding(), start = 20.dp, end = 20.dp)
    ) {
        // Row for the property information, pic. etc.
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // picture of the house
            Image(
                painter = painterResource(id = property.image),
                contentDescription = "Image of ${property.addressLineOne}",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            // text information about the property
            Spacer(Modifier.padding(5.dp))
            Column() {
                Text(property.addressLineOne, style = MaterialTheme.typography.headlineMedium)
                Text(property.addressRemainer, style = MaterialTheme.typography.titleMedium)
                Text(property.note)
            }
        }

        // show the house on a map
        // TODO make this show an actual map
        Spacer(Modifier.padding(10.dp))
        Image(
            painter = painterResource(id = R.drawable.googlemaps),
            contentDescription = "Image of the house on a map",
            modifier = Modifier
                .size(width = LocalConfiguration.current.screenWidthDp.dp, height = 100.dp)
                .clip(RectangleShape),
            contentScale = ContentScale.Crop
        )

        // taps to show either the tenants or bills
        Spacer(Modifier.padding(10.dp))
        TenantsBillsTabs(tenants)
    }
}

/**
 * Shows two secondary tabs - one for displaying a list of tenants
 * and one for showing a list of bills
 * @param List of tenants who live at a property
 */
@Composable
fun TenantsBillsTabs(tenants : List<TenantEntity>) {
    // TODO add onClick() and selected() methods to each Tab to make navigation work
    SecondaryTabRow(selectedTabIndex = 1) {
        Tab(selected = true, onClick = {}) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.Person, "Tenants icon")
                Text("Tenants")
            }
        }
        Tab(
            selected = false,
            onClick = {},
            text = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Bolt, "Bills icon")
                    Text("Bills")
                }
            }
        )
    }
    // TODO have these methods handled by navigation logic
    // TODO find the list of tenants using a method in the PropertyEntity database entity
    Spacer(Modifier.padding(top = 8.dp))
    // TenantTabList(tenants)
    BillsTabList(tenants)
}

/**
 * Shows a list of tenants with an email button
 */
@Composable
fun TenantTabList(tenants : List<TenantEntity>) {
    LazyColumn {
        items(tenants) { tenant ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(tenant.name)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {} // TODO make this open the email app?
                ) {
                    Icon(Icons.Filled.Email, "Email icon")
                }
            }
        }
    }
}

/**
 * Shows a list of all the utilities for a property, how much is outstanding,
 * and then breaks the outstanding payments down by tenant. Shows a tick/cross
 * icon to indicate who has paid
 * @param tenants [List] List of tenants in a property
 * @todo Completely refactor the whole function. Get details of bills, payments due, tenants from
 *      the [PropertyEntity] data class and the database.
 */
@Composable
fun BillsTabList(tenants : List<TenantEntity>) {
    // list of suppliers. TODO get this list from the PropertyEntity
    val suppliers = listOf(UtilitySupplierEntity(UtilityType.ELECTRICITY, "British Gas", ""),
        UtilitySupplierEntity(UtilityType.GAS, "British Gas", ""),
        UtilitySupplierEntity(UtilityType.BROADBAND, "Pine media", ""),
        UtilitySupplierEntity(UtilityType.WATER, "Yorkshire Water", ""))

    // show a section for each bill type
    // TODO only show sections with bills
    suppliers.forEach{ utility ->
        // show bill type and supplier
        Text("${utility.type} (${utility.name}) - £130", style = MaterialTheme.typography.titleMedium)

        // list of tenants, showing who has and hasn't paid
        LazyColumn {
            items(tenants) { tenant ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    // show different text and icons depending on paid status
                    if (tenant.name == "Boris Johnson") { // TODO make this tenants who haven't paid
                        Text("${tenant.name} has £48 left to pay")
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            onClick = {} // TODO make this open the email app?
                        ) {
                            Icon(Icons.Filled.Email, "Email icon")
                        }
                        Icon(Icons.Filled.Close, "Haven't paid icon")
                    } else {
                        // tenants who have paid
                        Text("${tenant.name} has paid")
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            onClick = {} // TODO make this open the email app?
                        ) {
                            Icon(Icons.Filled.Email, "Email icon")
                        }
                        Icon(Icons.Filled.Check, "Has paid icon")
                    }
                }
            }
        }
    }
}
