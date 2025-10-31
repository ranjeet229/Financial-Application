package com.example.financialapp.Activities.DashboardActivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financialapp.Activities.DashboardActivity.components.ActionButtonRow
import com.example.financialapp.Activities.DashboardActivity.components.CardSection
import com.example.financialapp.Activities.DashboardActivity.components.HeaderSection
import com.example.financialapp.Domain.ExpenseDomain

@Composable
@Preview(showBackground = true)
fun MainScreenPreview(){
    val expenses= listOf(
        ExpenseDomain("Resturant", 573.12, "img1", "20 jun 2025 20:20"),
        ExpenseDomain("KFC", 600.1, "img2", "18 jul 2025 10:23"),
        ExpenseDomain("McDonald", 73.13, "img3", "30 aug 2025 2:26"),
        ExpenseDomain("Cinema", 57.12, "img4", "30 oct 2025 17:18")
    )
     MainScreen(expenses = expenses)
}

@Composable
fun MainScreen(
    onCardClick: ()-> Unit={},
    expenses: List<ExpenseDomain>
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {
            item { HeaderSection() }
            item { CardSection (onCardClick) }
            item { ActionButtonRow() }
        }
    }
}