package ru.test.financyandrey.categories_screen.domain.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.test.financyandrey.categories_screen.data.di.dataMainScreenDi
import ru.test.financyandrey.accounts.domain.interactor.InteractorAccountImpl
import ru.test.financyandrey.categories_screen.domain.interactor.InteractorCategories
import ru.test.financyandrey.categories_screen.domain.interactor.InteractorCategoriesCategoriesImpl


fun domainMainScreenDi() = DI.Module("domainMainScreenDi") {
    importOnce(dataMainScreenDi())

    bind<InteractorCategories>() with singleton {
        InteractorCategoriesCategoriesImpl(
            repo = instance()
        )
    }
}