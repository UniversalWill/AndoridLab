package com.example.hardwarecomponent

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hardwarecomponent.room.viewmodel.CatalogViewModel
import com.example.hardwarecomponent.room.viewmodel.CpuViewModel
import com.example.hardwarecomponent.ui.theme.HardwarecomponentTheme
import java.util.Collections.emptyList

class MainActivity : ComponentActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализация MediaPlayer и запуск фоновой музыки
        mediaPlayer = MediaPlayer.create(this, R.raw.meme)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()


        setContent {
            HardwarecomponentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "catalog") {
                        composable("catalog") {
                            CatalogView(navigation = navController)
                        }
                        composable("Процессоры") {
                            CpuListView(navigation = navController)
                        }

                        composable("Материнские платы") {
                            CpuListView(navigation = navController)
                        }

                        composable("Оперативная память") {
                            CpuListView(navigation = navController)
                        }
                    }

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        // Освобождение ресурсов MediaPlayer
        mediaPlayer?.release()
        mediaPlayer = null
    }
}

@Composable
fun CatalogView(navigation: NavController, catalogViewModel: CatalogViewModel = viewModel()) {
    val catalog = catalogViewModel.allProducts.observeAsState(emptyList())

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(catalog.value) {item ->
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(width = 240.dp, height = 100.dp)
                    .clickable {
                        navigation.navigate(item.name)
                    }
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CpuListView(navigation: NavHostController, cpuViewModel: CpuViewModel = viewModel()) {
    val products = cpuViewModel.allCPU.observeAsState(emptyList())
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Процессоры", style = MaterialTheme.typography.labelLarge, fontSize = 18.sp)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navigation.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(products.value) {products ->
                Text(text = products.name + " " + products.price, modifier = Modifier.padding(16.dp))

            }
        }
    }
}
