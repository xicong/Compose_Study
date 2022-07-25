package com.cxi.compose_study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cxi.compose_study.ui.main.MainPage
import com.cxi.compose_study.ui.start.StartPage
import com.cxi.compose_study.ui.theme.Compose_StudyTheme
import com.cxi.compose_study.utils.RouteUtils
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            mainView()
        }
    }
}

@Composable
private fun  mainView(){
    Compose_StudyTheme{
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            rememberSystemUiController().run {
                setStatusBarColor(Color.Transparent, false)
                setNavigationBarColor(Color.Transparent, false)
            }
            RouteUtils.getInstance().initRoute()
        }
    }
}


//https://jetpackcompose.cn/docs/elements/text
//https://www.icode9.com/content-4-1063064.html
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    mainView()
}

