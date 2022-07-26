package com.cxi.compose_study.ui.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxi.compose_study.R
import com.cxi.compose_study.utils.appHeadView
import com.cxi.compose_study.utils.appNavBarView
import com.cxi.compose_study.utils.appRoundedView
import com.cxi.compose_study.utils.titleBarView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WidgetsTextFieldPage(){
    Column {
        titleBarView(
            title = "TextField"
        )
        LazyColumn{
            stickyHeader { 
                appHeadView(str = "基本展示")
            }
            item { 
                itemBorderView{
                    Row (
                        modifier = Modifier.padding(10.dp)
                    ){
                        var phone = remember { mutableStateOf("18888888888") }
                        TextField(
                            value = phone.value, 
                            textStyle = TextStyle(
                                fontSize = 10.sp
                            ),
                            onValueChange = {
                                phone.value = it
                            },
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
            stickyHeader {
                appHeadView(str = "visualTransformation:如密码的时候输入变成*号 ")
            }
            item {
                itemBorderView{
                    Row (
                        modifier = Modifier.padding(10.dp)
                    ){
                        var phone = remember { mutableStateOf("18888888888") }
                        TextField(
                            value = phone.value,
                            visualTransformation = PasswordVisualTransformation('*'),
                            textStyle = TextStyle(
                                fontSize = 10.sp
                            ),
                            onValueChange = {
                                phone.value = it
                            },
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
            stickyHeader {
                appHeadView(str = "placeholder = ")
            }
            item {
                itemBorderView{
                    Row (
                        modifier = Modifier.padding(10.dp)
                    ){
                        var phone = remember { mutableStateOf("") }
                        TextField(
                            value = phone.value,
                            textStyle = TextStyle(
                                fontSize = 10.sp
                            ),
                            onValueChange = {
                                phone.value = it
                            },
                            placeholder = {
                                Text("请输入手机号码")
                            },
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
            stickyHeader {
                appHeadView(str = "leadingIcon = \n trailingIcon =")
            }
            item {
                itemBorderView{
                    Row (
                        modifier = Modifier.padding(10.dp)
                    ){
                        var phone = remember { mutableStateOf("") }
                        TextField(
                            value = phone.value,
                            textStyle = TextStyle(
                                fontSize = 10.sp
                            ),
                            onValueChange = {
                                phone.value = it
                            },
                            placeholder = {
                                Text("请输入手机号码")
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null, // decorative element
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                    contentDescription = null, // decorative element
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
            }
            stickyHeader {
                appHeadView(str = "enabled = ")
            }
            item {
                itemBorderView{
                    Column{
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "enabled = false",
                                fontSize = 15.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f)
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                                enabled = false
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "enabled = true",
                                fontSize = 15.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f)
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                                enabled = true
                            )
                        }   
                    }
                }
            }
            stickyHeader {
                appHeadView(str = "isError = ")
            }
            item {
                itemBorderView{
                    Column{
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "isError = false",
                                fontSize = 15.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f)
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                                isError = false
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "isError = true",
                                fontSize = 15.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f)
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                                isError = true
                            )
                        }
                    }
                }
            }
            stickyHeader {
                appHeadView(str = "readOnly = ")
            }
            item {
                itemBorderView{
                    Column{
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "readOnly = false",
                                fontSize = 15.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f)
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                                readOnly = false
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "readOnly = true",
                                fontSize = 15.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f)
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                                readOnly = true
                            )
                        }
                    }
                }
            }
            stickyHeader {
                appHeadView(str = "label = ")
            }
            item {
                itemBorderView {
                    Column (
                        modifier = Modifier.padding(10.dp)
                    ){
                        var phone = remember { mutableStateOf("18888888888") }
                        TextField(
                            value = phone.value,
                            onValueChange = {
                                phone.value = it
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = {
                                Text("手机号码")
                            }
                        )
                        var psd = remember { mutableStateOf("123456") }
                        OutlinedTextField(
                            value = psd.value, 
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { psd.value = it },
                            label = { Text("密码")}
                        )
                    }
                }
            }
            stickyHeader {
                appHeadView(str = "capitalization = ")
            }
            item {
                itemBorderView {
                    Column (
                        modifier = Modifier.padding(10.dp)
                    ){
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "isError = true",
                                fontSize = 15.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                capitalization = KeyboardCapitalization.Sentences,
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                    }
                }
            }
            item { 
                appNavBarView()
            }
        }
    }
}

@Composable
private fun itemBorderView(content: @Composable () -> Unit ){
    appRoundedView (
        bgColor = Color.Transparent,
        content = content
    )
}