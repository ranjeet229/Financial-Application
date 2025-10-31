package com.example.financialapp.Activities.DashboardActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.financialapp.Activities.DashboardActivity.screens.MainScreen
import com.example.financialapp.ViewModel.MainViewModal
import com.example.financialapp.ui.theme.FinancialAppTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModal by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinancialAppTheme {
                MainScreen(expenses = mainViewModel.loadData(), onCardClick = {

                })
            }
        }
    }
}
