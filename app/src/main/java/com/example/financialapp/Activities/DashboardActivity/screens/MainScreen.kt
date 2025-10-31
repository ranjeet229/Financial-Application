package com.example.financialapp.Activities.DashboardActivity.screens

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.financialapp.Activities.DashboardActivity.components.ActionButtonRow
import com.example.financialapp.Activities.DashboardActivity.components.BottomNavigationBar
import com.example.financialapp.Activities.DashboardActivity.components.CardSection
import com.example.financialapp.Activities.DashboardActivity.components.ExpenseItem
import com.example.financialapp.Activities.DashboardActivity.components.HeaderSection
import com.example.financialapp.Domain.ExpenseDomain
import com.example.financialapp.R

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    val expenses = listOf(
        ExpenseDomain("Restaurant", 573.12, "restaurant", "20 Jun 2025 20:20"),
        ExpenseDomain("McDonald", 600.1, "mcdonald", "18 Jul 2025 10:23"),
        ExpenseDomain("Cinema", 73.13, "cinema", "30 Aug 2025 2:26"),
        ExpenseDomain("Restaurant", 57.12, "restaurant", "30 Oct 2025 17:18")
    )
    MainScreen(expenses = expenses)
}

@Composable
fun MainScreen(
    onCardClick: () -> Unit = {},
    expenses: List<ExpenseDomain>
) {

    val view = LocalView.current
    if (!view.isInEditMode) {
        val window = (view.context as Activity).window
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier.height(80.dp),
                onItemSelected = { itemId ->
                    if (itemId == R.id.wallet) {
                        // Handle wallet click
                    }
                }
            )
        },
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            HeaderSection()
            CardSection(onCardClick)
            ActionButtonRow()

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(expenses) { item ->
                    ExpenseItem(item)
                }
            }
        }
    }
}
