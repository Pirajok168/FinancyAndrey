package ru.test.financyandrey.accounts.data.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.test.financyandrey.accounts.data.repository.IRepositoryAccount
import ru.test.financyandrey.accounts.data.repository.IRepositoryAccountImpl
import ru.test.financyandrey.data.db.AppDatabase


fun dataDataAccountDi() = DI.Module("DataAccountDi") {
    bind<IRepositoryAccount>() with singleton {
        IRepositoryAccountImpl(
            accountDao = instance<AppDatabase>().accountDao()
        )
    }
}