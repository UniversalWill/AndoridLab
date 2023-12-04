package com.example.hardwarecomponent

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hardwarecomponent.room.entities.CPU
import com.example.hardwarecomponent.room.entities.Catalog
import com.example.hardwarecomponent.room.viewmodel.CpuViewModel
import com.example.hardwarecomponent.ui.theme.HardwarecomponentTheme

class MainActivity : ComponentActivity() {
    private val viewModel: CpuViewModel by viewModels()
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
                    Productlist(viewModel = viewModel)
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
fun Productlist(viewModel: CpuViewModel) {
    val products: List<CPU> by viewModel.allCPU.observeAsState(emptyList())
    
    LazyColumn {
        items(products) {products -> 
            Text(text = products.name + " " + products.price, modifier = Modifier.padding(16.dp))

        }
    }
}
