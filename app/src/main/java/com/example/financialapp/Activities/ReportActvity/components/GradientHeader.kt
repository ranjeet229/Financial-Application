package com.example.financialapp.Activities.ReportActvity.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.financialapp.R

@Composable
fun GradientHeader(modifier: Modifier = Modifier, onBack: () -> Unit) {
    ConstraintLayout(
        modifier = modifier
            .background(
                Brush.linearGradient(
                    colors = listOf(colorResource(R.color.lightBlue), Blue, Color(0xff4b64c0)),
                    start = Offset(0f, 0f),
                    end = Offset(1000f, 600f)
                ),
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
            )
            .padding(top = 40.dp) // manually add top padding instead of statusBarsPadding()
    ) {
        val (backBtn, title) = createRefs()

        IconButton(
            onClick = onBack,
            modifier = Modifier
                .size(48.dp)
                .padding(start = 16.dp)
                .constrainAs(backBtn) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow),
                contentDescription = null,
                tint = Color.White
            )
        }

        Text(
            "Monthly Report",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            modifier = Modifier
                .padding(start = 8.dp)
                .constrainAs(title) {
                    start.linkTo(backBtn.end)
                    top.linkTo(backBtn.top)
                    bottom.linkTo(backBtn.bottom)
                }
        )
    }
}

@Preview
@Composable
fun GradientHeaderPreview() {
    GradientHeader(onBack = {})
}
