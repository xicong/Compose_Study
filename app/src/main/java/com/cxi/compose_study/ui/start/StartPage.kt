package com.cxi.compose_study.ui.start

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cxi.compose_study.utils.MAINPAGE
import kotlinx.coroutines.delay

@Composable
fun StartPage(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Green),
        contentAlignment = Alignment.Center,
    ) {
        LaunchedEffect(Unit){
            delay(500)
            navHostController.navigate(MAINPAGE)
        }
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            shape = RoundedCornerShape(30.dp),
            border = BorderStroke(2.dp, Color.Yellow)
        ) {

            Surface(
                color = Color.Transparent,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                shape = RoundedCornerShape(30.dp),
                border = BorderStroke(2.dp, Color.Yellow)
            ) {

                Surface(
                    color = Color.Transparent,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    shape = RoundedCornerShape(30.dp),
                    border = BorderStroke(2.dp, Color.Yellow)
                ) {

                    Surface(
                        color = Color.Transparent,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        shape = RoundedCornerShape(30.dp),
                        border = BorderStroke(2.dp, Color.Yellow)
                    ) {

                        Surface(
                            color = Color.Transparent,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            shape = RoundedCornerShape(30.dp),
                            border = BorderStroke(2.dp, Color.Yellow)
                        ) {

                            Surface(
                                color = Color.Transparent,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(20.dp),
                                shape = RoundedCornerShape(30.dp),
                                border = BorderStroke(2.dp, Color.Yellow)
                            ) {
                            }
                        }
                    }
                }
            }
        }
        
        Text(
            text = "Compose",
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            ),
            color = Color.Yellow,
            textAlign = TextAlign.Center,
        )
        
    }

}
