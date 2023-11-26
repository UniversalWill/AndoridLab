package com.example.hardwarecomponent

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
import com.example.hardwarecomponent.room.entities.Catalog
import com.example.hardwarecomponent.room.viewmodel.CatalogViewModel
import com.example.hardwarecomponent.ui.theme.HardwarecomponentTheme

class MainActivity : ComponentActivity() {
    private val viewModel: CatalogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}

@Composable
fun Productlist(viewModel: CatalogViewModel) {
    val products: List<Catalog> by viewModel.allProducts.observeAsState(emptyList())
    
    LazyColumn {
        items(products) {products -> 
            Text(text = products.name, modifier = Modifier.padding(16.dp))
        }
    }
}
