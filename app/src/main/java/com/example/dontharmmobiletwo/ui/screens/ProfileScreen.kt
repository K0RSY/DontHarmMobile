package com.example.dontharmmobiletwo.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dontharmmobiletwo.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(context: Context, login: String?) {
    val vm: ProfileViewModel = viewModel() {
        ProfileViewModel(context, login!!)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        if (login != null) {
            Text(login)
        }
        OutlinedTextField(value = vm.password, onValueChange = {vm.changePassword(it)})
        OutlinedTextField(value = vm.names, onValueChange = {vm.changeNames(it)})
        OutlinedTextField(value = vm.birthDate, onValueChange = {vm.changeBirthDate(it)})
        OutlinedTextField(value = vm.email, onValueChange = {vm.changeEmail(it)})
        OutlinedTextField(value = vm.phone, onValueChange = {vm.changePhone(it)})
        Button(onClick = {
            vm.updateUser()
        }) {
            Text("Save")
        }
    }
}