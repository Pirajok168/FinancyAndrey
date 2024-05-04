package ru.test.financyandrey.accounts.ui.di

import org.kodein.di.DI
import ru.test.financyandrey.accounts.domain.di.domainAccountDi
import ru.test.financyandrey.appDi
import ru.test.financyandrey.categories_screen.domain.di.domainMainScreenDi

fun accountScreenDi() = DI {
    extend(appDi)
    importOnce(domainAccountDi())
}