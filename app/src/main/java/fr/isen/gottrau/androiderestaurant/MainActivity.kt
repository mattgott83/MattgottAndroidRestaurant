package fr.isen.gottrau.androiderestaurant

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.isen.gottrau.androiderestaurant.ui.theme.AndroidERestaurantTheme
import androidx.compose.ui.graphics.Color
import android.content.Intent





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting(::afficherToast)
                }
            }
        }
    }
    fun afficherToast(categorie: String) {
        Toast.makeText(this, categorie, Toast.LENGTH_SHORT).show()

        val intent = Intent(this@MainActivity, PlatsActivity::class.java)
        intent.putExtra("CATEGORY_KEY", categorie)
        startActivity(intent)
    }
}

@Composable
fun Greeting(afficherToast: (String) -> Unit)
{
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            // Logo en haut avec une taille ajustée et rogné en cercle
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo du site",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .background(Color.Black)  // Utilisez Color.Black comme couleur de fond
                    .padding(bottom = 0.17.dp)   // Augmentez ou diminuez l'espacement du bas selon vos besoins
            )


            // Trois boutons au milieu avec une taille doublée
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(32.dp)  // Ajustez l'espacement entre les boutons
            )
            {
                Button(
                    onClick = {
                        afficherToast("Entrées")
                        // Lancez la nouvelle activité avec la catégorie sélectionnée

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                ) {
                    Text("Entrées")
                }

                Button(
                    onClick = {
                        afficherToast("Plats")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                ) {
                    Text("Plats")
                }

                Button(onClick = { afficherToast("Desserts") },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                ) {
                    Text("Desserts")
                }
            }
        }
    }
}







/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidERestaurantTheme {
        Greeting(::afficherToast)
    }
}*/

