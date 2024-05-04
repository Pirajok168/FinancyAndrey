package ru.test.financyandrey.accounts.data.repository

import kotlinx.coroutines.flow.Flow
import ru.test.financyandrey.accounts.data.db.model.Account
import ru.test.financyandrey.categories_screen.data.db.model.OperationWithCategory

interface IRepositoryAccount {
    fun getAll(): Flow<List<Account>>

    fun insertAll(category: Account)


    fun accountInfo(): Flow<Map<Account, List<OperationWithCategory>>>
}