package uk.ac.sheffield.recolauntilitymanager

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.NavBar
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.ScreenName
import uk.ac.sheffield.recolauntilitymanager.ui.navigation.SmallAppBar

val sampleProperty = PropertyEntity(
    addressLineOne = "42 Pinstone Street",
    addressRemainer = "Sheffield, S1 2HH",
    image = 2131166324,
    numTenants = 3,
    geoLocation = "53.3811, -1.4701",
    note = "Recently renovated kitchen. Lease ends June 30th."
)
val tenants = listOf(TenantEntity(
    name = "Sarah Miller",
    email = "sarah.m@example.com",
    note = "Always pays on time",
    property = sampleProperty
),
    TenantEntity(
        name = "Tom Jackson",
        email = "t.jackson@example.com",
        note = "Likes to pay monthly rather than quarterly",
        property = sampleProperty
    ),
    TenantEntity(
        name = "Chloe Evans",
        email = "chloe.e@mail.com",
        note = "Never seen",
        property = sampleProperty
    ),
    TenantEntity(
        name = "David Lee",
        email = "david.l@mymail.co.uk",
        note = "Has burnt his bed by accident",
        property = sampleProperty
    ))

@Preview
@Composable
fun EditPropertyPage() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SmallAppBar(ScreenName.NEW_PROPERTY) },
        bottomBar = { NavBar(ScreenName.NEW_PROPERTY) {} }
    ) { innerPadding ->
        EditPage(innerPadding)
    }
}

@Composable
fun EditPage(innerPadding: PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.download),
                contentDescription = "Sample image",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,

            )
            Spacer(modifier = Modifier.width(6.dp))
            Column (
                modifier = Modifier.weight(1f)
            ){
                OutlinedTextField(
                    state = rememberTextFieldState("10 Downing Street"),
                    label = { Text("Address 1") },
                    modifier = Modifier.height(55.dp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)

                    )
                Row(){
                    OutlinedTextField(
                    state = rememberTextFieldState("SW1A 2AA"),
                    label = { Text("Postcode") },
                    modifier = Modifier.height(55.dp).weight(2f),
                        lineLimits = TextFieldLineLimits.MultiLine(minHeightInLines = 1, maxHeightInLines = 1),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    OutlinedTextField(
                        state = rememberTextFieldState("1"),
                        label = { Text("Beds") },
                        modifier = Modifier.height(55.dp).weight(1f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                        lineLimits = TextFieldLineLimits.MultiLine(minHeightInLines = 1, maxHeightInLines = 1),

                        
                    )
                }
                OutlinedTextField(
                    state = rememberTextFieldState("Go beyond the large metal gate then turn right"),
                    label = { Text("Note") },
                    lineLimits = TextFieldLineLimits.MultiLine(minHeightInLines = 2, maxHeightInLines = 2)

                )
            }


        }
        Spacer(modifier = Modifier.height(6.dp))
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()){
            Icon(Icons.Filled.Person, "Tenants icon")
            Text(text = "Tenants")
        }
        HorizontalDivider(thickness = 2.dp, color = Color(103, 80, 164))
        Spacer(modifier = Modifier.height(6.dp))
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(bottom = 8.dp)
        ){
            itemsIndexed(tenants) { index, tenant ->
                Column() {
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                    ) { Column(modifier = Modifier.padding(16.dp)) {
                            Text("Tenant ${index + 1}")
                            OutlinedTextField(
                                state = rememberTextFieldState(tenant.name),
                                label = { Text("Name") },
                                modifier = Modifier.fillMaxWidth().height(55.dp),
                                lineLimits = TextFieldLineLimits.MultiLine(minHeightInLines = 1, maxHeightInLines = 1),
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
                            )
                            OutlinedTextField(
                                state = rememberTextFieldState(tenant.email),
                                label = { Text("Email") },
                                modifier = Modifier.fillMaxWidth().height(55.dp),
                                lineLimits = TextFieldLineLimits.MultiLine(minHeightInLines = 1, maxHeightInLines = 1),
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
                            )
                            OutlinedTextField(
                                state = rememberTextFieldState(tenant.note),
                                label = { Text("Note") },
                                modifier = Modifier.fillMaxWidth().height(55.dp),
                                lineLimits = TextFieldLineLimits.MultiLine(minHeightInLines = 1, maxHeightInLines = 1),
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
                            )
                        }
                    }
                }
            }
        }
    }
}
