package ru.test.financyandrey.accounts.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import ru.test.financyandrey.categories_screen.data.db.model.Category
import ru.test.financyandrey.categories_screen.data.db.model.Operation


@Entity
data class Account(
    @PrimaryKey(autoGenerate = true) val idAccount: Int,
    val nameAccount: String,
    val sumAccount: String,
)
