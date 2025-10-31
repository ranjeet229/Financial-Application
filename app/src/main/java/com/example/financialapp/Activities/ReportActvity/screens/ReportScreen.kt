package com.example.financialapp.Activities.ReportActvity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.tooling.preview.Preview
import com.example.financialapp.Activities.ReportActvity.components.BudgetItem
import com.example.financialapp.Activities.ReportActvity.components.CenterStatsCard
import com.example.financialapp.Activities.ReportActvity.components.GradientHeader
import com.example.financialapp.Activities.ReportActvity.components.SummaryColumns
import com.example.financialapp.Domain.BudgetDomain
import com.example.financialapp.R

@Composable
fun ReportScreen(
    budgets: List<BudgetDomain>,
    onBack: () -> Unit
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (contentRef) = createRefs()

        ReportContent(
            budgets = budgets,
            modifier = Modifier
                .constrainAs(contentRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            onBack = onBack
        )
    }
}

@Composable
fun ReportContent(
    budgets: List<BudgetDomain>,
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(420.dp)
        ) {
            val (header, card) = createRefs()

            GradientHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                onBack = onBack
            )

            CenterStatsCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 24.dp)
                    .constrainAs(card) {
                        top.linkTo(header.bottom)
                        bottom.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }

        SummaryColumns(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .background(
                    colorResource(R.color.lightBlue),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "My budget",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                color = colorResource(R.color.darkBlue)
            )
            Text("Edit", color = colorResource(R.color.blue))
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(budgets) { index, item ->
                BudgetItem(budget = item, index = index)
            }
        }
    }
}

@Preview
@Composable
fun ReportScreenPreview() {
    val budgets = listOf(
        BudgetDomain(title = "Groceries", price = 250.0, percent = 25.3),
        BudgetDomain(title = "Entertainment", price = 150.0, percent = 15.8),
        BudgetDomain(title = "Bills", price = 300.0, percent = 30.9),
    )
    ReportScreen(
        budgets = budgets,
        onBack = {}
    )
}
