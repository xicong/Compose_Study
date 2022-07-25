package com.cxi.compose_study.ui.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxi.compose_study.ui.Anim.WidgetBean
import com.cxi.compose_study.utils.PAGE
import com.cxi.compose_study.utils.RouteUtils

@Composable
fun  WidgetsPage(){
    LazyColumn(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth()
    ){
        itemsIndexed(createData()){ index, item ->
           Card(
               shape = RoundedCornerShape(15.dp),
               border = BorderStroke(1.dp, Color.Green),
               modifier = Modifier.padding(top = 5.dp, bottom = 5.dp).fillMaxWidth().clickable { 
                   RouteUtils.getInstance().go(PAGE.WIDGETS_TEXT)
               }
           ) {
               Column (
                   verticalArrangement = Arrangement.SpaceEvenly,
                   modifier = Modifier.padding(20.dp).fillMaxWidth()
               ){
                   Text(text = item.name,
                       style = TextStyle(
                           fontWeight = FontWeight.Bold,
                           fontSize = 25.sp,
                           fontFamily = FontFamily.Default
                       ),
                       color = Color.Green
                   )
                   Text(text = item.describe,
                       style = TextStyle(
                           fontWeight = FontWeight.Bold,
                           fontSize = 15.sp,
                           fontFamily = FontFamily.Default
                       ),
                       color = Color.Green
                   )
               }
           }
        }
    }
}

private fun createData():List<WidgetBean>{
    val list = arrayListOf<WidgetBean>()
    list.add(WidgetBean("Text"," 是Compose 中最基本的布局组件，它可以显示文字"))
    list.add(WidgetBean("TextField"," 是Compose 中最基本的布局组件，它可以用来输入文字"))
    list.add(WidgetBean("Image"," 是Compose 中最基本的布局组件，以帮我们加载一张图片"))
    list.add(WidgetBean("Icon"," 是Compose 中最基本的布局组件，Icon组件用于帮助开发者显示一系列的小图标"))
    list.add(WidgetBean("IconButton"," 是Compose 中最基本的布局组件，可以帮助我们生成一个可点击的图标按钮"))
    list.add(WidgetBean("Button"," 是Compose 中最基本的布局组件，它可以用来进行点击交互"))
    list.add(WidgetBean("Card"," 是Compose 中最基本的布局组件，我们用它可以来创造出一些类似于卡片界面"))
    list.add(WidgetBean("FloatingActionButton"," 是Compose 中最基本的布局组件，我们用它可以来实现一个悬浮按钮"))
    list.add(WidgetBean("Slider"," 是Compose 中最基本的布局组件，允许用户从一定范围的数值中进行选择"))
    list.add(WidgetBean("Alertdialog"," 是Compose 中最基本的布局组件，允许用户实现一个弹窗交互"))
    return list
}

data class WidgetBean(val name:String,val describe:String)
