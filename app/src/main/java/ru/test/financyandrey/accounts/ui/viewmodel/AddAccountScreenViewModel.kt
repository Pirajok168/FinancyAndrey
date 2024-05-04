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
import ru.test.financyandrey.accounts.data.db.model.Account
import ru.test.financyandrey.accounts.domain.interactor.InteractorAccount
import ru.test.financyandrey.accounts.ui.di.accountScreenDi
import ru.test.financyandrey.accounts.ui.state.AddAccountScreenState
import ru.test.financyandrey.categories_screen.domain.interactor.InteractorCategories

class AddAccountScreenViewModel: ViewModel() {
    var state: AddAccountScreenState by mutableStateOf(AddAccountScreenState())
        private set

    private val di: DI by lazy { accountScreenDi() }

    fun inputName( name: String){
        state = state.copy(name = name)
    }

    fun inputSum( sum: String){
        state = state.copy( sumAccount= sum)
    }

    fun addAccount(){
        val interactor: InteractorAccount by di.instance<InteractorAccount>()
        val ssss: InteractorCategories by di.instance<InteractorCategories>()
        viewModelScope.launch(Dispatchers.IO) {
            interactor.insertAll(Account(0, state.name, state.sumAccount))
        }
    }
}