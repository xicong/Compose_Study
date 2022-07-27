package com.cxi.compose_study.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * 矩形圆角边框
 */
@Composable
fun appRoundedView(
    bgColor:Color ?= null,
    content: @Composable () -> Unit
) {
    Surface(
        color = bgColor ?: Color.Transparent,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, Color.Green),
        modifier = Modifier
            .background(Color.White)
            .padding(10.dp,5.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        content = content
    ) 
}

/**粘性HeadView*/
@Composable
fun  appHeadView(
    str:String
){
    appRoundedView(
        bgColor = Color.Green
    ) {
        Text(
            text = str,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
            fontSize = 12.sp,
            color = Color.White,
            textAlign = TextAlign.Start
        )
    }
}








