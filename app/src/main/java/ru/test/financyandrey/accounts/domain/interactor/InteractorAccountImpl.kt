package ru.test.financyandrey.accounts.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.test.financyandrey.accounts.data.db.model.Account
import ru.test.financyandrey.accounts.data.repository.IRepositoryAccount
import ru.test.financyandrey.categories_screen.data.db.model.OperationWithCategory

class InteractorAccountImpl(
    val repo: IRepositoryAccount
): InteractorAccount {
    override fun getAll(): Flow<List<Account>> =
        repo.getAll()

    override fun insertAll(category: Account) =
        repo.insertAll(category)

    override fun accountInfo(): Flow<Map<Account, List<OperationWithCategory>>> =
        repo.accountInfo()
}