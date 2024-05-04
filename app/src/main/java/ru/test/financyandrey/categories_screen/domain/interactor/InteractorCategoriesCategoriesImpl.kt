package ru.test.financyandrey.categories_screen.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.test.financyandrey.categories_screen.data.db.model.Category
import ru.test.financyandrey.categories_screen.data.db.model.AccountWithOperation
import ru.test.financyandrey.categories_screen.data.repository.IRepositoryCategories

class InteractorCategoriesCategoriesImpl(
    val repo: IRepositoryCategories
): InteractorCategories {
    override fun getAll(): Flow<List<Category>> =
        repo.getAll()

    override fun insertAll(category: Category) =
        repo.insertAll(category)

}