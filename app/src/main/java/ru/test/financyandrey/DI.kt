package ru.test.financyandrey

import android.app.Application
import org.kodein.di.DI
import org.kodein.di.android.x.androidXModule
import ru.test.financyandrey.data.di.databaseDi

lateinit var appDi: DI
    private set


fun initAppDi(app: Application) {
    appDi = DI {
        importOnce(androidXModule(app))
        importOnce(databaseDi(app.applicationContext))
    }
}