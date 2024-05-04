package ru.test.financyandrey.accounts.ui.state

import ru.test.financyandrey.accounts.data.db.model.Account
import ru.test.financyandrey.categories_screen.data.db.model.OperationWithCategory

data class AccountsScreenState(
    val accounts: Map<Account, List<OperationWithCategory>> = emptyMap(),
)