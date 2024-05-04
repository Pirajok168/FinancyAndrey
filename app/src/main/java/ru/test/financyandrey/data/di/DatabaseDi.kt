package ru.test.financyandrey.data.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import ru.test.financyandrey.data.db.AppDatabase

fun databaseDi(applicationContext: Context) = DI.Module("databaseDi") {
    bind<AppDatabase>() with singleton {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database-name"
        ).build()
    }
}