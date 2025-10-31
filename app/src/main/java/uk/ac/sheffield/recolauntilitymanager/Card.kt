package uk.ac.sheffield.recolauntilitymanager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun ElevatedCardExample(address: String = "10 downing street", tenants: Int = 1, image: Int = R.drawable.download) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "Sample image",
            modifier = Modifier
                .fillMaxWidth().height(150.dp),

            contentScale = ContentScale.Crop
        )
        Text(
            text = address,
            modifier = Modifier
                .padding(top = 6.dp, start = 6.dp),
            textAlign = TextAlign.Center,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 6.dp, bottom = 6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Bed,
                contentDescription = "Bedrooms",
                modifier = Modifier.size(16.dp),
                tint = Color.Gray

            )
            Text(
                text = "$tenants Bedrooms",
                modifier = Modifier
                    .padding(start = 4.dp),
                textAlign = TextAlign.Center,
                fontSize = 8.sp,
                color = Color.Gray
            )
        }
    }
}