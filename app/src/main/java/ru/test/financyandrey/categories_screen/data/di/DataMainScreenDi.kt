package ru.test.financyandrey.categories_screen.data.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.test.financyandrey.categories_screen.data.repository.IRepositoryCategories
import ru.test.financyandrey.data.db.AppDatabase
import ru.test.financyandrey.categories_screen.data.repository.IRepositoryCategoriesImpl


fun dataMainScreenDi() = DI.Module("dataMainScreenDi") {
    bind<IRepositoryCategories>() with singleton {
        IRepositoryCategoriesImpl(
            categoryDao = instance<AppDatabase>().categoryDao()
        )
    }
}