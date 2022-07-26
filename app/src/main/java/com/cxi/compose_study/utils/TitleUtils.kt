package com.cxi.compose_study.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

/**titleBar*/
@Composable
fun titleBarView(
    title:String?=null
){
    titleBarView(
        leftIcon =  Icons.Filled.ArrowBack,
        title = title,
        leftIconListen = {
            RouteUtils.getInstance().back()
        }
    )
}
@Composable
fun titleBarView(
    leftIcon: ImageVector?=null,
    leftIconListen:(()->Unit)?=null,
    title:String?=null
){
    Column {
        appStatusBarView()
        TopAppBar(
            navigationIcon = {
                leftIcon?.let {
                    IconButton(onClick = {
                        leftIconListen?.invoke()
                    }) {
                        Icon(leftIcon, null, tint = Color.White)
                    }
                }
            },
            backgroundColor = Color.Green,
            title = {
                title?.let {
                    Text(title,
                        color = Color.White
                    )
                }
            },
            elevation = 0.dp
        )
    }
}