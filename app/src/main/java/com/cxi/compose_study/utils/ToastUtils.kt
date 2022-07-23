package com.cxi.compose_study.utils

import android.widget.Toast
import androidx.compose.runtime.Composable
import com.cxi.compose_study.App



fun toast(msg:String){
    Toast.makeText(App.app,msg,Toast.LENGTH_LONG).show()
}