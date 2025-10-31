package com.example.financialapp.Activities.ReportActvity.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financialapp.R


@Composable
fun SummaryColumns(modifier: Modifier= Modifier){
    Row(
        modifier = modifier.height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SummaryColumn(
            title = "Total Balance",
            value="₹7,356.32",
            percent="+21%",
            percentColor= Color(0xff2d9738),
            modifier = Modifier.weight(1f)
        )
        VerticalDivider()
        SummaryColumn(
            title = "Income",
            value="₹1890.36",
            percent="-13%",
            percentColor= Color(0xffef2642),
            modifier = Modifier.weight(1f)
        )
        VerticalDivider()
        SummaryColumn(
            title = "Saving",
            value="₹87362.36",
            percent="+27%",
            percentColor= Color(0xff2d9738),
            modifier = Modifier.weight(1f)
        )
    }
}
@Preview
@Composable
fun SummaryColumnsPreview(){
    SummaryColumns()
}

@Composable
fun SummaryColumn(
    title: String,
    value: String,
    percent: String,
    percentColor: Color,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
        Text(title, color = colorResource(R.color.darkBlue))
        Text(
            value, color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Text(percent, color = percentColor)
    }
}