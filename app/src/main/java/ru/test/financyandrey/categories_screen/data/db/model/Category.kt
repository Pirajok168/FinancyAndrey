package ru.test.financyandrey.categories_screen.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import ru.test.financyandrey.accounts.data.db.model.Account


enum class TypeCategory {
    Income,
    Expenses
}


enum class ColorCategory{
    Orange,
    Red,
    Green
}

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val name: String,
    val typeCategory: TypeCategory,
    val color: ColorCategory,
    val icon: Int
)

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("categoryId"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Account::class,
            parentColumns = arrayOf("idAccount"),
            childColumns = arrayOf("accountId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Operation(
    @PrimaryKey(autoGenerate = true) val idOperation: Int,
    val sum: String,
    val categoryId: Int,
    val accountId: Int
)
