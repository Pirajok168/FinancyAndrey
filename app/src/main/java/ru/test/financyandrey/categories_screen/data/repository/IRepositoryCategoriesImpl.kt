package ru.test.financyandrey.categories_screen.data.repository

import kotlinx.coroutines.flow.Flow
import ru.test.financyandrey.categories_screen.data.db.CategoryDao
import ru.test.financyandrey.categories_screen.data.db.model.Category
import ru.test.financyandrey.categories_screen.data.db.model.AccountWithOperation

class IRepositoryCategoriesImpl(
    val categoryDao: CategoryDao
): IRepositoryCategories {
    override fun getAll(): Flow<List<Category>> =
        categoryDao.getAll()

    override fun insertAll(category: Category) =
        categoryDao.insertAll(category)
}