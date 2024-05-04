package ru.test.financyandrey.categories_screen.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.instance
import ru.test.financyandrey.categories_screen.data.db.model.Category
import ru.test.financyandrey.categories_screen.domain.interactor.InteractorCategories
import ru.test.financyandrey.categories_screen.ui.di.mainScreenDi
import ru.test.financyandrey.categories_screen.ui.state.CategoriesScreenState

class CategoriesScreenViewModel : ViewModel() {

    private val di: DI by lazy { mainScreenDi() }

    var state: CategoriesScreenState by mutableStateOf(CategoriesScreenState())
        private set

    init {
        val interactor: InteractorCategories by di.instance<InteractorCategories>()
        viewModelScope.launch(Dispatchers.IO) {
            interactor.getAll()
                .collect {
                    viewModelScope.launch(Dispatchers.Main) {
                        state = state.copy(categories = it)
                    }
                }
        }
    }


    fun addCategory(){
        val interactor: InteractorCategories by di.instance<InteractorCategories>()

        viewModelScope.launch(Dispatchers.IO) {
             interactor.insertAll(state.selectCategories!!)
        }
    }

    fun inputSum(sum: String) {
        state = state.copy(sum = sum)
    }

    fun selectedCategorie(category: Category){
        state = state.copy(selectCategories= category)
    }

}