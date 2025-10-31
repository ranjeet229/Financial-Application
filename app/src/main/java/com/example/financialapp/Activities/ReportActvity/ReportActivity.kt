package com.example.financialapp.Activities.ReportActvity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.financialapp.Activities.ReportActvity.screens.ReportScreen
import com.example.financialapp.R
import com.example.financialapp.ViewModel.MainViewModal

class ReportActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModal by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReportScreen(
                budgets = mainViewModel.loadBudget(),
                onBack = {finish()}
            )
        }
    }
}