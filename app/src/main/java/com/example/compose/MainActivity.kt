package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import ir.kaaveh.sdpcompose.sdp
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

                MyText(myText.value)
                MyTextField()
                MyOutLinedTextField()
                MyButton()
                MyGroupRadioButton()
                MyFAB()
                MyProgress()
                MyAlertDialog()
            }
        }
    }
}

@Composable
fun MyText(text: String) {
    Text(
        text = text,
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

val myText = mutableStateOf("")

@Composable
fun MyButton() {
    Button(
        onClick = { myText.value = "Button clicked" },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.yellow)),
        border = BorderStroke(2.sdp, colorResource(id = R.color.red))
    ) {

        Column {
            Text(text = stringResource(id = R.string.button), color = colorResource(id = R.color.blue))
            Text(text = "smallerText", fontSize = 6.ssp)
        }
    }
}

@Composable
fun MyGroupRadioButton() {

    val radioButtons = listOf(0, 1, 2)
    val selectedButton = remember {
        mutableIntStateOf(radioButtons[0])
    }

    Column {
        radioButtons.forEach { index ->
            val isSelected = index == selectedButton.value

            val colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(id = R.color.red),
                unselectedColor = colorResource(id = R.color.blue),
                disabledSelectedColor = colorResource(id = R.color.yellow),
            )

            RadioButton(
                selected = isSelected,
                onClick = { selectedButton.value = index },
                colors = colors,
            )

        }
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        contentColor = colorResource(id = R.color.yellow),
        content = { Text(text = "+") }
    )
}

@Composable
fun MyProgress() {
    CircularProgressIndicator(
        color = colorResource(id = R.color.red),
        strokeWidth = 3.sdp
    )

    LinearProgressIndicator()
}

@Composable
fun MyAlertDialog() {

    val shouldShowDialog = remember {
        mutableStateOf(true)
    }

   if (shouldShowDialog.value){
       AlertDialog(
           title = { Text(text = "Title")},
           text = { Text(text = "Text body")},
           onDismissRequest = { shouldShowDialog.value = false },
           confirmButton = {
               Button(onClick = { shouldShowDialog.value = false }) {
                   Text(text = "Confirm")
               }
           },
           dismissButton = {
               Button(onClick = { shouldShowDialog.value = false }) {
                   Text(text = "Cancel")
               }
           }
       )
   }
}
























