package com.example.myapplication.Components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckBoxComponent(textValue:String) {
    Row(
    ){
        var checkedState by remember {
            mutableStateOf(false)
        }
        if(textValue=="By Signing up, you agree to the Terms of Service \n" +
            "and Privacy Policy") {
            Checkbox(checked = checkedState, onCheckedChange = {checkedState= !checkedState})
            ClickableTextComponent(value = textValue)
        }
        else{
            Row(
                modifier = Modifier.heightIn(40.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Checkbox(checked = checkedState, onCheckedChange = {checkedState= !checkedState})
                Text(
                    text = textValue,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 40.dp)
                        .align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal
                    )
                )
            }
        }
    }
}

@Composable
fun ClickableTextComponent(value: String){
    val start = "By Signing up, you agree to the "
    val tos = "Terms Of Service"
    val and = " and "
    val privacy ="Privacy Policy"

    val annotedString = buildAnnotatedString {
        append(start)
        withStyle(style = SpanStyle( color = MaterialTheme.colorScheme.primary)){
            pushStringAnnotation(tag = tos, annotation = tos)
            append(tos)
        }
        append(and)
        withStyle(style = SpanStyle( color = MaterialTheme.colorScheme.primary)){
            pushStringAnnotation(tag = privacy, annotation = privacy)
            append(privacy)
        }
    }

    ClickableText(text = annotedString, onClick = {offset ->
        annotedString.getStringAnnotations(offset,offset).firstOrNull()?.also{span->
            Log.d("ClickableText","{$span}")
        }
    } )
}