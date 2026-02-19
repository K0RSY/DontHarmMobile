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
import com.example.dontharmmobiletwo.data.model.Credentials
import com.example.dontharmmobiletwo.data.repository.UserRepository
import kotlin.math.log

@Composable
fun RegistrationScreen(context: Context) {
    Surface(modifier = Modifier.fillMaxSize()) {
        val userRepository = UserRepository(context)
        val login = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        Column() {
            OutlinedTextField(login.value, {login.value = it})
            OutlinedTextField(password.value, {password.value = it}, visualTransformation = PasswordVisualTransformation())
            Button(onClick = {
                if (userRepository.register(login.value, password.value)) {
                    context.startActivity(Intent(context, MainActivity::class.java))
                } else {
                    Toast.makeText(context, "Registration failed!", Toast.LENGTH_SHORT).show()
                }
            }) { Text("Register") }
        }
    }
}