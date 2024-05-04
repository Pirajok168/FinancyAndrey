package ru.test.financyandrey.accounts.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.test.financyandrey.accounts.ui.viewmodel.AccountsScreenViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsScreen(
    accountsScreenViewModel: AccountsScreenViewModel = viewModel(),
    addAccount: () -> Unit
) {
    val state = accountsScreenViewModel.state
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text(text = "Cчета") },
                actions = {
                    IconButton(onClick = addAccount) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            state.accounts.forEach { (account, info) ->
                account.let {
                    Text(text = "Имя счета = ${it.sumAccount}", style = MaterialTheme.typography.labelMedium)
                    Text(text = "Баланс = ${it.sumAccount}")
                }
                info.forEach { operationWithCategory ->
                    Divider()
                    Text(text = "Категория = ${operationWithCategory.category.name}")
                    Text(text = "Траты по категории")
                    operationWithCategory.operations.forEach { 
                        Text(text = "Сумма = ${it.sum}")
                    }
                }
            }
        }
    }
}