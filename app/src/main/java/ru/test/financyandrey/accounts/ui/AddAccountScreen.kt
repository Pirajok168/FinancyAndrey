package ru.test.financyandrey.accounts.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.test.financyandrey.accounts.ui.viewmodel.AddAccountScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAccountScreen(
    addAccountScreenViewModel: AddAccountScreenViewModel = viewModel(),
    onBack: () -> Unit
) {
    val state = addAccountScreenViewModel.state
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text(text = "Добавление счета") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        },
        bottomBar = {
            Box(modifier = Modifier.padding(16.dp)){
                Button(
                    onClick = { addAccountScreenViewModel.addAccount(); onBack() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Добавить счет")
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            OutlinedTextField(value = state.name, onValueChange = addAccountScreenViewModel::inputName)
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(value = state.sumAccount, onValueChange = addAccountScreenViewModel::inputSum)
        }
    }
}