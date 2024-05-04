package ru.test.financyandrey.categories_screen.ui.di

import org.kodein.di.DI
import ru.test.financyandrey.appDi
import ru.test.financyandrey.categories_screen.domain.di.domainMainScreenDi

fun mainScreenDi() = DI {
    extend(appDi)
    importOnce(domainMainScreenDi())
}