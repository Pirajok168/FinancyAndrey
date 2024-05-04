package ru.test.financyandrey.accounts.domain.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.test.financyandrey.accounts.data.di.dataDataAccountDi
import ru.test.financyandrey.accounts.domain.interactor.InteractorAccount
import ru.test.financyandrey.accounts.domain.interactor.InteractorAccountImpl


fun domainAccountDi() = DI.Module("domainAccountDi") {
    importOnce(dataDataAccountDi())

    bind<InteractorAccount>() with singleton {
        InteractorAccountImpl(
            repo = instance()
        )
    }
}