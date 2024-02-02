package fr.isen.gottrau.androiderestaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.isen.gottrau.androiderestaurant.ui.theme.AndroidERestaurantTheme
import android.content.Context
import androidx.compose.foundation.lazy.items


class PlatsActivity : ComponentActivity() {

    //Déclaration liste des mes plats
    private val entreesList = listOf("Verrine de thon", "Carpaccio de boeuf", "salade césar")
    private val platsList = listOf("Gratin dauphinois", "Lasagnes", "Pizza chèvre-miel")
    private val dessertsList = listOf("Tiramisu", "Les gateaux IKEA", "Quadro")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                val selectedCategory = intent.getStringExtra("CATEGORY_KEY") ?: ""
        val selectedPlatsList = when (selectedCategory)
        {
            "Entrées" -> entreesList
            "Plats" -> platsList
            "Desserts" -> dessertsList
            else -> emptyList() //Gestion en cas de défaut
        }
        setContent {
            AndroidERestaurantTheme {
                // Récupère la catégorie sélectionnée

                // Affiche la nouvelle activité avec la catégorie et la liste des plats
                PlatsScreen(selectedCategory, selectedPlatsList)
            }
        }
    }
}

@Composable
fun PlatsScreen(selectedCategory: String, platsList: List<String>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Affiche la catégorie sélectionnée
            Text(text = "Catégorie: $selectedCategory", color = Color.Black, style = MaterialTheme.typography.bodyMedium)


            // Affiche la liste des plats
            PlatsList(platsList)
        }
    }
}

@Composable
fun PlatsList(platsList: List<String>) {
    LazyColumn {
        // Affiche la liste de plats en utilisant LazyColumn
        items(platsList) { plat ->
            Text(plat)
        }
    }
}

// Utilisez cet aperçu pour visualiser la nouvelle activité
/*@Preview(showBackground = true)
@Composable
fun PlatsScreenPreview() {
    AndroidERestaurantTheme {
        PlatsScreen(selectedCategory = "Entrées")
    }
}*/
