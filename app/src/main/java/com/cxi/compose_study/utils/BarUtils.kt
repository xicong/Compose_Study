package com.cxi.compose_study.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.SizeUtils
import com.google.accompanist.insets.statusBarsHeight

fun statusBarHeight(): Dp = SizeUtils.px2dp(BarUtils.getStatusBarHeight().toFloat()).dp

fun navBarHeight():Dp= SizeUtils.px2dp(BarUtils.getNavBarHeight().toFloat()).dp

@Composable
fun statusBarView(){
    Surface(
        modifier = Modifier
            .statusBarsHeight(statusBarHeight())//设置状态栏高度
            .fillMaxWidth(),
        color = Color.Green
    ){}
}

@Composable
fun navBarView(){
    Surface(
        modifier = Modifier
            .statusBarsHeight(navBarHeight())//设置状态栏高度
            .fillMaxWidth(),
        color = Color.Green
    ){}
}

