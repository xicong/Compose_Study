package com.cxi.compose_study.ui.Layout

import androidx.compose.foundation.BorderStroke
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
import com.cxi.compose_study.ui.widgets.WidgetBean

@Composable
fun  LayoutPage(){
    LazyColumn(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth()
    ){
        itemsIndexed(createData()){ index, item ->
           Card(
               shape = RoundedCornerShape(15.dp),
               border = BorderStroke(1.dp, Color.Green),
               modifier = Modifier.padding(top = 5.dp, bottom = 5.dp).fillMaxWidth()
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
    list.add(WidgetBean("Box","Box 是一个能够将里面的子项依次按照顺序堆叠的布局组件。"))
    list.add(WidgetBean("BottomNavigation","允许在一个应用程序的主要目的地之间移动。"))
    list.add(WidgetBean("Column","Column 是一个布局组件，它能够将里面的子项按照从上到下的顺序垂直排列。"))
    list.add(WidgetBean("Row","Row 组件能够将里面的子项按照从左到右的方向水平排列。和 Column 组件一起配合，我们可以构建出很丰富的界面。"))
    list.add(WidgetBean("ModalBottomSheetLayout","可以在App的底部弹出，并且能够将背景暗化。"))
    list.add(WidgetBean("Scaffold","Scaffold 实现了 Material Design 的基本视图界面结构如以下的侧边应用栏、底部导航栏、导航栏都可以在 Scaffold 函数下自动布局完成。"))
    list.add(WidgetBean("Card"," 是Compose 中最基本的布局组件，我们用它可以来创造出一些类似于卡片界面"))
    list.add(WidgetBean("FloatingActionButton"," 是Compose 中最基本的布局组件，我们用它可以来实现一个悬浮按钮"))
    list.add(WidgetBean("Slider"," 是Compose 中最基本的布局组件，允许用户从一定范围的数值中进行选择"))
    list.add(WidgetBean("Alertdialog"," 是Compose 中最基本的布局组件，允许用户实现一个弹窗交互"))
    return list
}

data class WidgetBean(val name:String,val describe:String)
