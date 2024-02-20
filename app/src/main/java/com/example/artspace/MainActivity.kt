package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Display()
            }
        }
    }
}

@Composable
fun Display(modifier: Modifier = Modifier)
{
    var currentPainting by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        )
        {
            when(currentPainting)
            {
                1 -> Painting(R.drawable.las_meninas_01, "Las Meninas", "Las Meninas", "Diego Velázquez (1656)")
                2 -> Painting(R.drawable.la_familia_de_carlos_iv__por_francisco_de_goya, "La familia de Carlos IV", "La familia de Carlos IV", "Francisco de Goya (1800)")
                else -> Painting(R.drawable._83px_the_isleworth_mona_lisa, "Monna Lisa", "Monna Lisa", "Leonardo Da VInci (1503-1519)")
            }
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            )
            {
                Button(
                    onClick = { currentPainting = (currentPainting-1).mod(3) }
                )
                {
                    Text(text = "Previous")
                }
                Spacer(modifier = Modifier.padding(50.dp))
                Button(
                    onClick = { currentPainting = (currentPainting+1).mod(3) }
                )
                {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Composable
fun Painting(imgCuadroId: Int, imgDesc: String, titulo: String, autor: String)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .size(width = 300.dp, height = 400.dp)
    )
    {
        Image(
            painter = painterResource(imgCuadroId),
            contentDescription = imgDesc,
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.LightGray)
    )
    {
        Text(
            text = titulo,
            fontSize = 24.sp
        )
        Text(text = autor)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Display()
    }
}