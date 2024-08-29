package com.example.artspaceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

// Class to hold image details
class ArtPiece(
    val imageRes: Int,
    val title: String,
    val artist: String,
    val date: String
)

@Composable
fun ArtSpaceContent(modifier: Modifier = Modifier) {
    val artPieces = listOf(
        ArtPiece(R.drawable.lion, "Lion", "Juma Kariuki", "Published on 10/10/2023"),
        ArtPiece(R.drawable.leopard, "Leopard", "James Doe", "Published on 3/12/2023"),
        ArtPiece(R.drawable.rhino, "Rhino", "John Doe", "Published on 01/05/2024"),
        ArtPiece(R.drawable.elephant, "Elephant", "Mary Doe", "Published on 05/07/2024"),
        ArtPiece(R.drawable.buffalo, "Buffalo", "Mike Daniel", "Published on 08/03/2024")
    )

    var currentIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .padding(top = 50.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image at the top
        Image(
            painter = painterResource(id = artPieces[currentIndex].imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .padding(bottom = 16.dp)
        )

        // Card below the image
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.8f)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(text = artPieces[currentIndex].title)
                Text(text = "Image by ${artPieces[currentIndex].artist}")
                Text(text = artPieces[currentIndex].date)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Buttons for Next and Previous
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Previous Button
            Button(
                onClick = {
                    if (currentIndex > 0) currentIndex--
                },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Previous")
            }

            // Next Button
            Button(
                onClick = {
                    if (currentIndex < artPieces.size - 1) currentIndex++
                },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}
