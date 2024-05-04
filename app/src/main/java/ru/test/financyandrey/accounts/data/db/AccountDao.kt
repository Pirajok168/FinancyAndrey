package ru.test.financyandrey.accounts.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ru.test.financyandrey.accounts.data.db.model.Account
import ru.test.financyandrey.categories_screen.data.db.model.OperationWithCategory


@Dao
interface AccountDao {

    @Query("SELECT * FROM Account")
    fun getAll(): Flow<List<Account>>


    @Insert
    fun insertAll(category: Account)


    @Transaction
    @Query("SELECT * FROM Account JOIN OPERATION ON Account.idAccount == OPERATION.accountId" +
            " JOIN CATEGORY ON OPERATION.categoryId == CATEGORY.uid")
    fun accountInfo(): Flow<Map<Account, List<OperationWithCategory>>>
}