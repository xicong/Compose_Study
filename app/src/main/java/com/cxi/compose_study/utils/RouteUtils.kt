package com.cxi.compose_study.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cxi.compose_study.ui.main.MainPage
import com.cxi.compose_study.ui.start.StartPage
import com.cxi.compose_study.ui.widgets.WidgetsTextFieldPage
import com.cxi.compose_study.ui.widgets.WidgetsTextPage

class RouteUtils private constructor(){
    companion object{
        fun getInstance() = Helper.instance
    }
    private object Helper{
        val instance = RouteUtils()
    }
    
    private lateinit var navController:NavHostController
    @Composable
    fun initRoute(){
        navController = rememberNavController()
        NavHost(navController = navController, startDestination = PAGE.STARTPAGE.name){
            composable(route = PAGE.STARTPAGE.name){
                StartPage()
            }
            composable(route = PAGE.MAINPAGE.name){
                MainPage( )
            }
            composable(route = PAGE.WIDGETS_TEXT.name){
                WidgetsTextPage( )
            }
            composable(route = PAGE.WIDGETS_TEXTFILD_PAGE.name){
                WidgetsTextFieldPage()
            }
        }
    }
    
    fun go(page:PAGE){
        go(page,false)
    }
    fun go(page:PAGE,isSingTop:Boolean){
        navController.navigate(page.name){
            launchSingleTop = isSingTop
        }
        println("栈信息${navController.backQueue.filter { it.destination.route!=null }.map { it.destination.route }}")
    }
    
    fun back(){
        navController.popBackStack()
        println("栈信息${navController.backQueue.filter { it.destination.route!=null }.map { it.destination.route }}")
    }

}

enum class PAGE{
    /**启动页*/
    STARTPAGE ,
    /**主页*/
    MAINPAGE,
    /**TEXT*/
    WIDGETS_TEXT,
    /**TextField*/
    WIDGETS_TEXTFILD_PAGE,
}