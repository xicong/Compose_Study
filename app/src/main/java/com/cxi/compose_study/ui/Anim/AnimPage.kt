package com.cxi.compose_study.ui.Anim

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
fun  AnimPage(){
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
    list.add(WidgetBean("Anim","动画"))
    return list
}

data class WidgetBean(val name:String,val describe:String)
