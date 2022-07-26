package com.cxi.compose_study.ui.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxi.compose_study.R
import com.cxi.compose_study.ui.Anim.AnimPage
import com.cxi.compose_study.ui.Layout.LayoutPage
import com.cxi.compose_study.ui.widgets.WidgetsPage
import com.cxi.compose_study.utils.appNavBarView
import com.cxi.compose_study.utils.titleBarView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun MainPage(){
    val scope = rememberCoroutineScope()
    var mScaffoldState = rememberScaffoldState()
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Widgets", "Layout", "Anim")
    Scaffold(
        scaffoldState = mScaffoldState,
        topBar = {
            mainTitleBarView(scope,mScaffoldState,items, selectedItem)
        },
        bottomBar = { 
            Column {
                BottomNavigation (
                    backgroundColor = Color.Green
                ){
                    items.forEachIndexed { index, item ->
                        BottomNavigationItem(
                            icon = {
                                when(index){
                                    0 -> Icon(Icons.Filled.Home, contentDescription = null)
                                    1 -> Icon(Icons.Filled.Favorite, contentDescription = null)
                                    else -> Icon(Icons.Filled.Person, contentDescription = null)
                                }
                            },
                            label = { Text(item) },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            selectedContentColor = Color.Yellow,
                            unselectedContentColor = Color.White
                        )
                    }
                }
                appNavBarView(Color.Green)
            }            
        },
        drawerBackgroundColor = Color.Green,
        drawerContent = {
            drawerView(mScaffoldState, scope)
        }
    ){
        contentView(items,selectedItem,it)
    }
}

/***/
@Composable
private fun contentView(
    items:List<String>,
    selectedItem:Int,
    it:PaddingValues
){
    Column (){
        Surface(modifier = Modifier.weight(1f)) {
            when(selectedItem){
                0-> WidgetsPage()
                1-> LayoutPage()
                2-> AnimPage()
            }
        }
        Spacer(
            modifier = Modifier.height(80.dp)
        )
    }
}

/**titleBar*/
@Composable
private fun mainTitleBarView(
    scope:CoroutineScope,
    mScaffoldState:ScaffoldState,
    items:List<String>,
    selectedItem:Int,
){
    titleBarView(
        leftIcon = Icons.Filled.Menu,
        leftIconListen = {
            scope.launch {
                mScaffoldState.drawerState.open()
            }
        },
        title = items[selectedItem]
    )
}


/**侧边栏*/
@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun drawerView(
    mScaffoldState:ScaffoldState,
    scope: CoroutineScope
) {
    Surface(
        border = BorderStroke(1.dp, Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(20.dp, 40.dp),
        shape = RoundedCornerShape(15.dp),
        color = Color.Green
    ) {
        
        Row (
            horizontalArrangement = Arrangement.Start,
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
                    .size(width = 60.dp, height = 60.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
            )
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp, bottom = 20.dp)
                    .fillMaxHeight()
            ){
                Text(text = "小王",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        fontFamily = FontFamily.Default
                    ),
                    color = Color.White
                )
                Text(text = "攻城狮",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Default
                    ),
                    color = Color.White
                )
                Text(text = "广东 深圳",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Default
                    ),
                    color = Color.White
                )
                Text(text = "活到老，学到老",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Default
                    ),
                    color = Color.White
                )
            }
        }
    }
    // 编写逻辑
    // 如果 drawer 已经展开了，那么点击返回键收起而不是直接退出 app
    BackHandler(enabled = mScaffoldState.drawerState.isOpen) {
        scope.launch {
            mScaffoldState.drawerState.close()
        }
    }
}