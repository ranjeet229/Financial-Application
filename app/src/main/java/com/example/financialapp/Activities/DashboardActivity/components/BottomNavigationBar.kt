package com.example.financialapp.Activities.DashboardActivity.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financialapp.R

@Composable
fun BottomNavigationBar(
    onItemSelected: (Int) -> Unit,
    modifier: Modifier
) {


    NavigationBar(
        containerColor = colorResource(R.color.lightBlue),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected(R.id.wallet) },
            icon = {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(colorResource(R.color.lightBlue), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.wallet),
                        contentDescription = null,
                        tint = colorResource(R.color.darkBlue)
                    )
                }
            },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Black
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected(R.id.market) },
            icon = {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(colorResource(R.color.lightBlue), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.market),
                        contentDescription = null,
                        tint = colorResource(R.color.darkBlue)
                    )
                }
            },
            label = { Text("Market") },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Black
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected(R.id.trade) },
            icon = {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(colorResource(R.color.lightBlue), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.trade),
                        contentDescription = null,
                        tint = colorResource(R.color.darkBlue)
                    )
                }
            },
            label = { Text("Trade") },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Black
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected(R.id.futures) },
            icon = {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(colorResource(R.color.lightBlue), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.futures),
                        contentDescription = null,
                        tint = colorResource(R.color.darkBlue)
                    )
                }
            },
            label = { Text("Futures") },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Black
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { onItemSelected(R.id.profile) },
            icon = {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(colorResource(R.color.lightBlue), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = null,
                        tint = colorResource(R.color.darkBlue)
                    )
                }
            },
            label = { Text("Profile") },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Black
            )
        )
    }
}
