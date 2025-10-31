package uk.ac.sheffield.recolauntilitymanager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val numbers = (0..20).toList()

val properties = listOf<PropertyEntity>(
    PropertyEntity("10 Downing Street","", R.drawable.download, 1, "", ""),
    PropertyEntity("36 Craticliffe Road","", R.drawable.download, 3, "", ""),
    PropertyEntity("14 Pendlehurst Lane","", R.drawable.download, 5, "", ""),
    PropertyEntity("82 Marlingdon Street","", R.drawable.download, 6, "", ""),
    PropertyEntity("27 Blythemere Road","", R.drawable.download, 2, "", ""),
    PropertyEntity("59 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("54 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("52 Corbridge Avenue","", R.drawable.download, 4, "", ""),
)


@Composable
fun MyGrid(innerPaddingValues: PaddingValues){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(
            top = innerPaddingValues.calculateTopPadding() + 8.dp,
            bottom = innerPaddingValues.calculateBottomPadding() + 16.dp, // space for shadow
            start = 8.dp,
            end = 8.dp
        ),
    ) {
        items(properties) {
            ElevatedCardExample(it.addressLineOne, it.numTenants, it.image)
        }
    }
}
