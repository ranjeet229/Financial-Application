package com.example.financialapp.Activities.IntroActivity.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.financialapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun IntroScreen(
    onStartClick: () -> Unit = {}
) {
    var dragOffset by rememberSaveable { mutableStateOf(0f) }
    var isCompleted by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val animatedOffset by animateFloatAsState(
        targetValue = dragOffset,
        animationSpec = spring(dampingRatio = 0.7f, stiffness = 200f),
        label = "swipeAnimation"
    )

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (image, swipeBox, title) = createRefs()

        Image(
            painter = painterResource(R.drawable.intro_pic),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )

        Text(
            text = "The Best App to\nmanage your\nmoney",
            color = Color.White,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(title) {
                    bottom.linkTo(swipeBox.top, margin = 32.dp)
                    start.linkTo(parent.start, margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .constrainAs(swipeBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 48.dp)
                }
                .padding(horizontal = 32.dp)
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    color = Color.White.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(30.dp)
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            val maxWidth = 260f
            val swipeThreshold = maxWidth * 0.85f

            Box(
                modifier = Modifier
                    .offset(x = animatedOffset.dp)
                    .size(60.dp)
                    .background(Color.White, CircleShape)
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures(
                            onDragEnd = {
                                if (dragOffset > swipeThreshold) {
                                    isCompleted = true
                                    scope.launch {
                                        delay(300)
                                        onStartClick()
                                        dragOffset = 0f
                                        isCompleted = false
                                    }
                                } else {
                                    dragOffset = 0f
                                }
                            }
                        ) { _, dragAmount ->
                            dragOffset = (dragOffset + dragAmount)
                                .coerceIn(0f, maxWidth)
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = Color.Black
                )
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = when {
                        dragOffset > 50f -> "Keep Swiping "
                        else -> "Get Started"
                    },
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
