package ru.test.financyandrey.categories_screen.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ru.test.financyandrey.categories_screen.data.db.model.Category
import ru.test.financyandrey.categories_screen.data.db.model.AccountWithOperation


@Dao
interface CategoryDao {

    @Query("SELECT * FROM Category")
    fun getAll(): Flow<List<Category>>


    @Insert
    fun insertAll(category: Category)

}