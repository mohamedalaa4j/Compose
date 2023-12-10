package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import ir.kaaveh.sdpcompose.ssp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column( // Linearlayout -> vertical
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                MyText()
                MyTextField()
                MyOutLinedTextField()
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyText() {
    Text(
        text = "Hello!",
        color = colorResource(id = R.color.yellow),
        fontSize = 20.ssp
    )
}

@Composable
fun MyTextField() {
    val textValue = remember {
        mutableStateOf("")
    }

    TextField(value = textValue.value,
        onValueChange = { text ->
            textValue.value = text
        },
        label = { Text(text = "like hint") }
    )
}

@Composable
fun MyOutLinedTextField() {
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = { text ->
            textValue.value = text
        },
        label = {
            Text(text = stringResource(id = R.string.hint))
        },

        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),

        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = colorResource(id = R.color.yellow),
            focusedBorderColor = colorResource(id = R.color.yellow)
        )
    )
}
