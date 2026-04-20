package com.ndejje.momologin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ndejje.momologin.model.AppDatabase
import com.ndejje.momologin.model.UserRepository
import com.ndejje.momologin.ui.theme.MoMoLoginAppTheme
import com.ndejje.momologin.viewmodel.AuthViewModel
import com.ndejje.momologin.viewmodel.AuthViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getInstance(applicationContext)
        val repository = UserRepository(database.userDao())
        val viewModel: AuthViewModel by viewModels {
            AuthViewModelFactory(repository)
        }

        setContent {
            MoMoLoginAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation(viewModel = viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MoMoLoginAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            // Preview content
        }
    }
}
