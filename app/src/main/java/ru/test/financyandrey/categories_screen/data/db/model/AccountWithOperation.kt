package ru.test.financyandrey.categories_screen.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Relation
import ru.test.financyandrey.accounts.data.db.model.Account


data class AccountWithOperation(
    @Embedded
    val account: Account,

    @Relation(
        parentColumn = "idAccount",
        entityColumn = "accountId"
    )
    val operations: List<Operation>
)


data class OperationWithCategory(
    @Embedded
    val category: Category,

    @Relation(
        parentColumn = "uid",
        entityColumn = "categoryId"
    )
    val operations: List<Operation>
)