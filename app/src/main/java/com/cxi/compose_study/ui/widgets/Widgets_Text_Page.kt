package com.cxi.compose_study.ui.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxi.compose_study.utils.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WidgetsTextPage() {
    Column {
        titleBarView(
            title = "Text"
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            stickyHeader {
                appHeadView(
                    "text = Hellow Word" +
                            "\n" + "fontSize = 12.sp" +
                            "\n" + "color = Color.Green"
                )
            }
            item {
                itemBorderView {
                    Text(
                        text = "Hellow Word",
                        fontSize = 10.sp,
                        color = Color.Green,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            stickyHeader {
                appHeadView(
                    " letterSpacing = 10.dp"
                )
            }
            item {
                itemBorderView {
                    Text(
                        text = "Hellow Word",
                        fontSize = 10.sp,
                        color = Color.Green,
                        modifier = Modifier.padding(10.dp),
                    )
                }
            }
            stickyHeader {
                appHeadView(
                    "buildAnnotatedString实现富文本"
                )
            }
            item {
                itemBorderView {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Gray, fontSize = 10.sp)){
                                append("阅读并同意")
                            }
                            withStyle(style = SpanStyle(color = Color.Green, fontSize = 10.sp)){
                                append("《用户协议》")
                            }
                            withStyle(style = SpanStyle(color = Color.Gray, fontSize = 10.sp)){
                                append("和")
                            }
                            withStyle(style = SpanStyle(color = Color.Green, fontSize = 10.sp)){
                                append("《隐私协议》")
                            }
                            withStyle(style = SpanStyle(color = Color.Gray, fontSize = 10.sp)){
                                append("。")
                            }
                        },
                        fontSize = 10.sp,
                        color = Color.Green,
                        modifier = Modifier.padding(10.dp),
                    )
                }
            }
            stickyHeader {
                appHeadView(
                    "buildAnnotatedString实现富文本并且可以点击不同文字实现不同事件"
                )
            }
            item {
                itemBorderView {
                    val annotatedText = buildAnnotatedString {
                        append("Click ")
                        // We attach this *URL* annotation to the following content
                        // until `pop()` is called
                        pushStringAnnotation(tag = "URL",
                            annotation = "https://developer.android.com")
                        withStyle(style = SpanStyle(color = Color.Blue,
                            fontWeight = FontWeight.Bold)) {
                            append("here")
                        }
                        pop()
                    }
                    ClickableText(
                        text = annotatedText,
                        modifier = Modifier.padding(10.dp),
                        onClick = { offset ->
                            // We check if there is an *URL* annotation attached to the text
                            // at the clicked position
                            annotatedText.getStringAnnotations(tag = "URL", start = offset,
                                end = offset)
                                .firstOrNull()?.let { annotation ->
                                    // If yes, we log its value
                                    toast("Clicked URL"+annotation.item)
                                }
                        }
                    )
                }
            }
            stickyHeader {
                appHeadView(
                    "SelectionContainer:实现文字可复制"
                )
            }
            item {
                itemBorderView {
                    Column (
                        modifier = Modifier.padding(10.dp)
                    ){
                        SelectionContainer(modifier = Modifier.fillMaxSize()) {
                            Text(
                                text = "我是可以选择的, 我是可以选择的, 我是可以选择的",
                                fontSize = 10.sp,
                                color = Color.Green,
                                lineHeight = 30.sp
                            )
                        }
                        SelectionContainer(modifier = Modifier.fillMaxSize()) {
                            Column {
                                Text(text = "我是可选的",
                                    fontSize = 10.sp,
                                    color = Color.Green,
                                    lineHeight = 30.sp
                                )
                                Text(text = "我是可选的",
                                    fontSize = 10.sp,
                                    color = Color.Green,
                                    lineHeight = 30.sp
                                )
                                DisableSelection {
                                    Text(text = "我是不可选的",
                                        fontSize = 10.sp,
                                        color = Color.Green,
                                        lineHeight = 30.sp
                                    )
                                }
                                Text(text = "我是可选的",
                                    fontSize = 10.sp,
                                    color = Color.Green,
                                    lineHeight = 30.sp
                                )
                            }
                        }
                    }
                }
            }
            stickyHeader {
                appHeadView(
                    " lineHeight = 30.sp"
                )
            }
            item {
                itemBorderView {
                    Text(
                        text = "Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word",
                        fontSize = 10.sp,
                        color = Color.Green,
                        modifier = Modifier.padding(10.dp),
                        lineHeight = 30.sp
                    )
                }
            }
            stickyHeader {
                appHeadView(
                    "获取点击文字的位置"
                )
            }
            item {
                itemBorderView {
                    ClickableText(
                        text = AnnotatedString("Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word"),
                        modifier = Modifier.padding(10.dp),
                       style = TextStyle(
                           fontSize = 10.sp,
                           color = Color.Green,
                           lineHeight = 30.sp
                       ),
                        onClick = {
                            toast("位置$it")
                        }
                    )
                }
            }
            stickyHeader {
                appHeadView(
                    "Shadow阴影"
                )
            }
            item {
                itemBorderView {
                    Text(
                        text = "Hellow word",
                        fontSize = 10.sp,
                        color = Color.Green,
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f),
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Gray,
                                offset = Offset(5.0f, 10.0f),
                                blurRadius = 3f
                            )
                        )
                    )
                }
            }
            stickyHeader {
                appHeadView(
                    " overflow = TextOverflow.Visible"
                )
            }
            item {
                itemBorderView {
                    Column {
                        Row {
                            Text(
                                text = "TextOverflow.Visible",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                            Text(
                                text = "Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                overflow = TextOverflow.Visible,
                                maxLines = 1
                            )
                        }
                        Row {
                            Text(
                                text = "TextOverflow.Clip",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                            Text(
                                text = "Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                overflow = TextOverflow.Clip,
                                maxLines = 1
                            )
                        }
                        Row {
                            Text(
                                text = "TextOverflow.Ellipsis",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                            Text(
                                text = "Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word Hellow Word",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                    }
                }
            }
            stickyHeader {
                appHeadView(
                    "fontFamily = FontFamily.Default"
                )
            }
            item {
                itemBorderView {
                    Column {
                        Row {
                            Text(
                                text = "FontFamily.Default",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                        }
                        Row {
                            Text(
                                text = "FontFamily.Cursive",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Cursive,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                        }
                        Row {
                            Text(
                                text = "FontFamily.Monospace",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Monospace,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                        }
                        Row {
                            Text(
                                text = "FontFamily.Serif",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Serif,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                        }
                        Row {
                            Text(
                                text = "FontFamily.SansSerif",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.SansSerif,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f)
                            )
                        }
                    }
                }
            }
            stickyHeader {
                appHeadView(
                    "fontStyle = FontStyle.Normal"
                )
            }
            item {
                itemBorderView {
                    Column {
                        Row {
                            Text(
                                text = "FontStyle.Normal",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal
                            )
                        }
                        Row {
                            Text(
                                text = "FontStyle.Italic",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Italic
                            )
                        }
                    }
                }
            }
            stickyHeader {
                appHeadView(
                    "textDecoration = TextDecoration.None"
                )
            }
            item {
                itemBorderView {
                    Column {
                        Row {
                            Text(
                                text = "TextDecoration.None",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                textDecoration = TextDecoration.None
                            )
                        }
                        Row {
                            Text(
                                text = "TextDecoration.LineThrough",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                textDecoration = TextDecoration.LineThrough
                            )
                        }
                        Row {
                            Text(
                                text = "TextDecoration.Underline",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                textDecoration = TextDecoration.Underline
                            )
                        }
                    }
                }
            }
            stickyHeader {
                appHeadView(
                    "fontWeight = FontWeight.Normal"
                )
            }
            item {
                itemBorderView {
                    Column {
                        Row {
                            Text(
                                text = "FontWeight.Normal",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.Bold",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.Black",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Black,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.ExtraBold",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.ExtraBold,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.Light",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Light,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.ExtraLight",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.ExtraLight,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.Medium",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Medium,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.SemiBold",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.Thin",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Thin,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.W100",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.W100,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.W200",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.W200,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.W300",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.W300,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.W400",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.W400,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.W500",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.W500,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.W600",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.W600,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.W700",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.W700,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.W800",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.W800,
                            )
                        }
                        Row {
                            Text(
                                text = "FontWeight.W900",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                            )
                            Text(
                                text = "Hellow",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.W900,
                            )
                        }
                    }
                }
            }
            stickyHeader {
                appHeadView(
                    "textAlign = TextAlign.Center"
                )
            }
            item {
                itemBorderView {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "TextAlign.Start",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start,
                            )
                            Text(
                                text = "Hellow word",
                                fontSize = 10.sp,
                                color = Color.White,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(0.dp)
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(Color.Green),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start,
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "TextAlign.End",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start,
                            )
                            Text(
                                text = "Hellow word",
                                fontSize = 10.sp,
                                color = Color.White,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(0.dp)
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(Color.Green),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.End,
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "TextAlign.Left",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start,
                            )
                            Text(
                                text = "Hellow word",
                                fontSize = 10.sp,
                                color = Color.White,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(0.dp)
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(Color.Green),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Left,
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "TextAlign.Right",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start,
                            )
                            Text(
                                text = "Hellow word",
                                fontSize = 10.sp,
                                color = Color.White,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(0.dp)
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(Color.Green),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Right,
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "TextAlign.Center",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start,
                            )
                            Text(
                                text = "Hellow word",
                                fontSize = 10.sp,
                                color = Color.White,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(0.dp)
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(Color.Green),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "TextAlign.Justify",
                                fontSize = 10.sp,
                                color = Color.Green,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .weight(1f),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start,
                            )
                            Text(
                                text = "Hellow word",
                                fontSize = 10.sp,
                                color = Color.White,
                                fontFamily = FontFamily.Default,
                                modifier = Modifier
                                    .padding(0.dp)
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(Color.Green),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Justify,
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
private fun itemBorderView(content: @Composable () -> Unit) {
    appRoundedView (
        bgColor = Color.Transparent,
        content = content
    )
}
