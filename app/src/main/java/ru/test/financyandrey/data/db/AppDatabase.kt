package ru.test.financyandrey.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.test.financyandrey.accounts.data.db.AccountDao
import ru.test.financyandrey.accounts.data.db.model.Account
import ru.test.financyandrey.categories_screen.data.db.CategoryDao
import ru.test.financyandrey.categories_screen.data.db.model.Category
import ru.test.financyandrey.categories_screen.data.db.model.Operation

@Database(entities = [Account::class, Category::class, Operation::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao

    abstract fun accountDao(): AccountDao
}