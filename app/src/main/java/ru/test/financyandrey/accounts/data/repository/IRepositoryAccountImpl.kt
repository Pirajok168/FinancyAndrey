package ru.test.financyandrey.accounts.data.repository

import kotlinx.coroutines.flow.Flow
import ru.test.financyandrey.accounts.data.db.AccountDao
import ru.test.financyandrey.accounts.data.db.model.Account
import ru.test.financyandrey.categories_screen.data.db.model.OperationWithCategory

class IRepositoryAccountImpl(
    val accountDao: AccountDao
): IRepositoryAccount {
    override fun getAll(): Flow<List<Account>> =
        accountDao.getAll()

    override fun insertAll(category: Account) =
        accountDao.insertAll(category)

    override fun accountInfo(): Flow<Map<Account, List<OperationWithCategory>>> =
        accountDao.accountInfo()


}