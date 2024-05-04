package ru.test.financyandrey.categories_screen.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.test.financyandrey.categories_screen.data.db.model.Category
import ru.test.financyandrey.categories_screen.data.db.model.AccountWithOperation

interface InteractorCategories {
    fun getAll(): Flow<List<Category>>

    fun insertAll(category: Category)
}