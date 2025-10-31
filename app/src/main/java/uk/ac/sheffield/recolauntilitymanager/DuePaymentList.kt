import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.sheffield.recolauntilitymanager.PropertyEntity
import uk.ac.sheffield.recolauntilitymanager.R

val properties = listOf<PropertyEntity>(
    PropertyEntity("10 Downing Street","", R.drawable.download, 1, "", ""),
    PropertyEntity("36 Craticliffe Road","", R.drawable.download, 3, "", ""),
    PropertyEntity("14 Pendlehurst Lane","", R.drawable.download, 5, "", ""),
    PropertyEntity("82 Marlingdon Street","", R.drawable.download, 6, "", ""),
    PropertyEntity("27 Blythemere Road","", R.drawable.download, 2, "", ""),
    PropertyEntity("59 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("54 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("52 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("52 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("52 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("52 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("52 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("52 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("52 Corbridge Avenue","", R.drawable.download, 4, "", ""),
    PropertyEntity("52 Corbridge Avenue","", R.drawable.download, 4, "", ""),

)

@Composable
fun MyList(innerPaddingValues: PaddingValues) {

    LazyColumn (
        contentPadding = PaddingValues(
            top = innerPaddingValues.calculateTopPadding() + 8.dp,
            bottom = innerPaddingValues.calculateBottomPadding() + 16.dp,
            start = 8.dp,
            end = 8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        itemsIndexed(properties) {index, property ->
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp, top = 8.dp)
                        .clickable{},
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Text(
                        text = property.addressLineOne,
                        modifier = Modifier,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Toggle Button",
                        modifier = Modifier.size(24.dp),

                    )
                }
                if(index != properties.lastIndex){
                    HorizontalDivider(
                        thickness = 1.dp,
                    )
                }
            }
        }
    }
}

