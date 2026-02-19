package com.example.dontharmmobiletwo.ui.screens

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.dontharmmobiletwo.MainActivity
import com.example.dontharmmobiletwo.RegistrationActiviry
import com.example.dontharmmobiletwo.data.model.Credentials
import com.example.dontharmmobiletwo.data.repository.UserRepository
import kotlin.math.log

@Composable
fun AuthorizationScreen(context: Context) {
    Surface(modifier = Modifier.fillMaxSize()) {
        val login = remember { mutableStateOf("") }
        val userRepository = UserRepository(context)
        userRepository.loadStartUsers()
        val password = remember { mutableStateOf("") }
        val credentials = remember { mutableStateOf(Credentials()) }
        Column() {
            OutlinedTextField(login.value, {login.value = it})
            OutlinedTextField(password.value, {password.value = it}, visualTransformation = PasswordVisualTransformation())
            Button(onClick = {
                if (userRepository.authorize(login.value, password.value)) {
                    val intent = Intent(context, MainActivity::class.java)
                    intent.putExtra("login", login.value)
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Authorization failed!", Toast.LENGTH_SHORT).show()
                }
            }) { Text("Authorize") }
            Button(onClick = {
                context.startActivity(Intent(context, RegistrationActiviry::class.java))
            }) { Text("Register...") }
        }
    }
}