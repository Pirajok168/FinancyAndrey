package ru.test.financyandrey.accounts.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.instance
import ru.test.financyandrey.accounts.domain.interactor.InteractorAccount
import ru.test.financyandrey.accounts.ui.di.accountScreenDi
import ru.test.financyandrey.accounts.ui.state.AccountsScreenState
import ru.test.financyandrey.accounts.ui.state.AddAccountScreenState

class AccountsScreenViewModel(): ViewModel() {
    private val di: DI by lazy { accountScreenDi() }

    var state: AccountsScreenState by mutableStateOf(AccountsScreenState())
        private set


    init {
        val interactor: InteractorAccount by di.instance<InteractorAccount>()
        viewModelScope.launch(Dispatchers.IO) {
            interactor.accountInfo()
                .collect{
                    viewModelScope.launch(Dispatchers.Main) {
                        state = state.copy(accounts = it)
                    }
                }
        }
    }
}