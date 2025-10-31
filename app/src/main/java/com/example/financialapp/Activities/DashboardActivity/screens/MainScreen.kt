package com.example.financialapp.Activities.DashboardActivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        ExpenseDomain("Resturant", 573.12, "resturant", "20 jun 2025 20:20"),
        ExpenseDomain("McDonald", 600.1, "mcdonald", "18 jul 2025 10:23"),
        ExpenseDomain("Cinema", 73.13, "cinema", "30 aug 2025 2:26"),
        ExpenseDomain("Resturant", 57.12, "resturant", "30 oct 2025 17:18")
    )
    MainScreen(expenses = expenses)
}

@Composable
fun MainScreen(
    onCardClick: () -> Unit = {},
    expenses: List<ExpenseDomain>
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier.height(80.dp),
                onItemSelected = { itemId ->
                    if (itemId == R.id.wallet) {

                    }
                }
            )
        }

    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item { HeaderSection() }
            item { CardSection(onCardClick) }
            item { ActionButtonRow() }
            items(expenses) { item ->
                ExpenseItem(item)
            }
        }
    }
}
