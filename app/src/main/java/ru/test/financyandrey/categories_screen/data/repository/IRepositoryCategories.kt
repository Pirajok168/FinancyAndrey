package ru.test.financyandrey.categories_screen.data.repository

import kotlinx.coroutines.flow.Flow
import ru.test.financyandrey.categories_screen.data.db.model.Category
import ru.test.financyandrey.categories_screen.data.db.model.AccountWithOperation

interface IRepositoryCategories {
    fun getAll(): Flow<List<Category>>

    fun insertAll(category: Category)
}