package ru.test.financyandrey.categories_screen.ui.state

import ru.test.financyandrey.categories_screen.data.db.model.Category

data class CategoriesScreenState(
    val categories: List<Category> = emptyList(),
    val sum: String = "",
    val selectCategories: Category? = null
)
