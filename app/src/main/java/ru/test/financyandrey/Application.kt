package ru.test.financyandrey
import android.app.Application


class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        initAppDi(app = this)
    }

}