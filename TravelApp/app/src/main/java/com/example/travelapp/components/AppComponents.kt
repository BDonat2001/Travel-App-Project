package com.example.travelapp.components

import android.service.autofill.OnClickAction
import android.util.Log
import android.widget.CheckBox
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R
import com.example.travelapp.Screen
import com.example.travelapp.TravelAppNavHost

@Composable
fun NormalTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center
    )
}
@Composable
fun SimpleOutlinedTextFieldComponent(labelValue:String) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(labelValue) },
        keyboardOptions = KeyboardOptions.Default
    )
}

@Composable
fun OutlinedPasswordTextFieldComponent(labelValue:String) {
    var password by remember { mutableStateOf("") }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(labelValue) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            var iconImage = if(passwordVisible){
              Icons.Filled.Visibility
            }
            else{
                Icons.Filled.VisibilityOff
            }
            var description = if(passwordVisible){
                "Hide Password"
            }else{
                "Show Password"
            }
            IconButton(onClick = {passwordVisible = !passwordVisible}) {
                Icon(imageVector = iconImage, contentDescription = description )
            }
        }
    )
}
@Composable
fun BackComponent(){
    IconButton(onClick = {TravelAppNavHost.navigateTo(Screen.WelcomeScreen) }) {
        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back to Welcome page" )
    }
}
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
@Composable
fun ClickableTextComponentAuth(value: String, onTextSelected : (String)->Unit){
    if(value=="Sign In"){
        val start = "Already have an account? "

        val annotedString = buildAnnotatedString {
            append(start)
            withStyle(style = SpanStyle( color = MaterialTheme.colorScheme.primary)){
                pushStringAnnotation(tag = value, annotation = value)
                append(value)
            }
        }

        ClickableText(text = annotedString, onClick = {offset ->
            annotedString.getStringAnnotations(offset,offset).firstOrNull()?.also{span->
                Log.d("ClickableText","{$span}")

                if(span.item == value){
                    onTextSelected(span.item)
                }
            }
        } )
    }else{
        val start = "Don't have an account? "

        val annotedString = buildAnnotatedString {
            append(start)
            withStyle(style = SpanStyle( color = MaterialTheme.colorScheme.primary)){
                pushStringAnnotation(tag = value, annotation = value)
                append(value)
            }
        }

        ClickableText(text = annotedString, onClick = {offset ->
            annotedString.getStringAnnotations(offset,offset).firstOrNull()?.also{span->
                Log.d("ClickableText","{$span}")

                if(span.item == value){
                    onTextSelected(span.item)
                }
            }
        } )
    }
}

@Composable
fun WelcomeScreenButtonComponent(textValue:String, onClick: (Screen) -> Unit) {
    if(textValue=="Sign Up") {
        Button(
            onClick = { onClick(Screen.SignUpScreen) },
            modifier = Modifier
                .width(120.dp)
                .height(40.dp)
                .background(color = Color(0xFFE8DEF8), shape = RoundedCornerShape(size = 100.dp))


        ) {

            Text(text = textValue, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }else if(textValue=="Sign In"){
        Button(
            onClick = { onClick(Screen.SignInScreen) },
            modifier = Modifier
                .width(120.dp)
                .height(40.dp)
                .background(color = Color(0xFFE8DEF8), shape = RoundedCornerShape(size = 100.dp))


        ) {

            Text(text = textValue, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}
@Composable
fun AuthButtonComponent(textValue:String, onClick: (Screen) -> Unit) {
    Button(onClick = {onClick(Screen.HomeScreen) },
        modifier = Modifier
            .width(120.dp)
            .height(40.dp)
            .background(color = Color(0xFFE8DEF8), shape = RoundedCornerShape(size = 100.dp))


    ) {

        Text(text = textValue, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ResetPasswordText(){
    Text(
        text = "Reset Password",
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = MaterialTheme.colorScheme.primary,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun ImageCardComponent(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Adjust height as needed
    ) {
        Image(
            painter = painterResource(id = R.drawable.placeholder), // Replace with your actual image resource
            contentDescription = "App Illustration",
            modifier = Modifier.fillMaxSize()
        )
    }
}