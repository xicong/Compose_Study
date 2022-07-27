package com.cxi.compose_study.ui.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxi.compose_study.R
import com.cxi.compose_study.utils.appHeadView
import com.cxi.compose_study.utils.appNavBarView
import com.cxi.compose_study.utils.appRoundedView
import com.cxi.compose_study.utils.titleBarView

//https://juejin.cn/post/6951563170150350884
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
                        val interactionSource = remember { MutableInteractionSource() }
                        TextField(
                            value = phone.value,
                            textStyle = TextStyle(
                                fontSize = 10.sp
                            ),
                            onValueChange = {
                                phone.value = it
                            },
                            modifier = Modifier
                                .fillMaxSize(),
                            interactionSource = interactionSource,
                            shape= RoundedCornerShape(20.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.White,
                                backgroundColor = Color.Green,
                            ),
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
                appHeadView(str = "keyboardOptions = ")
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
                                text = "capitalization= KeyboardCapitalization.None /n 不自动大小写",
                                fontSize = 10.sp,
                                color = Color.Green,
                                textAlign = TextAlign.Start,
                                lineHeight = 16.sp,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(0.dp)
                                    .weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.None,
                                    keyboardType= KeyboardType.Text,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "capitalization= KeyboardCapitalization.Sentences /n 当输入英文时候，将每个字母的第一个字符大写",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Sentences,
                                    keyboardType= KeyboardType.Text,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "capitalization= KeyboardCapitalization.Words /n 当输入英文的时候，将每个字母的第一个字符小写",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Words,
                                    keyboardType= KeyboardType.Text,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "capitalization= KeyboardCapitalization.Characters /n 将所有的字符大写",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.Text,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "autoCorrect=false /n 自动更正的意思",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.Text,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=false,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "autoCorrect=true /n 自动更正的意思",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.Text,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "keyboardType= KeyboardType.Text /n 是输入文本",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.Text,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "keyboardType= KeyboardType.Ascii /n 是输入ASCII字符",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.Ascii,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "keyboardType= KeyboardType.Number /n 输入数字",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.Number,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "keyboardType= KeyboardType.Phone /n 输入电话",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.Phone,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "keyboardType= KeyboardType.Uri /n 输入Uri",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.Uri,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "keyboardType= KeyboardType.Email /n 输入Email",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.Email,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "keyboardType= KeyboardType.Password /n 输入Password",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.Password,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "keyboardType= KeyboardType.NumberPassword /n 输入NumberPassword",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.NumberPassword,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "imeAction = ImeAction.None",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.NumberPassword,
                                    imeAction = ImeAction.None,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "imeAction = ImeAction.Next",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.NumberPassword,
                                    imeAction = ImeAction.Next,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "imeAction = ImeAction.Default",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.NumberPassword,
                                    imeAction = ImeAction.Default,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "imeAction = ImeAction.Go",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.NumberPassword,
                                    imeAction = ImeAction.Go,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "imeAction = ImeAction.Done",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.NumberPassword,
                                    imeAction = ImeAction.Done,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "imeAction = ImeAction.Previous",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.NumberPassword,
                                    imeAction = ImeAction.Previous,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "imeAction = ImeAction.Search",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.NumberPassword,
                                    imeAction = ImeAction.Search,
                                    autoCorrect=true,
                                ),
                                onValueChange = {
                                    phone.value = it
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                        Row (
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "imeAction = ImeAction.Send",
                                fontSize = 10.sp,
                                lineHeight = 16.sp,
                                color = Color.Green,
                                modifier = Modifier.weight(0.6f),
                            )
                            var phone = remember { mutableStateOf("18888888888") }
                            TextField(
                                value = phone.value,
                                keyboardOptions = KeyboardOptions(
                                    capitalization= KeyboardCapitalization.Characters,
                                    keyboardType= KeyboardType.NumberPassword,
                                    imeAction = ImeAction.Send,
                                    autoCorrect=true,
                                ),
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