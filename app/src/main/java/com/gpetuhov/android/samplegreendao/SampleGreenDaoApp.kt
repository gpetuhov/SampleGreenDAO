package com.gpetuhov.android.samplegreendao

import android.app.Application

class SampleGreenDaoApp : Application() {

    lateinit var daoSession: DaoSession

    override fun onCreate() {
        super.onCreate()

        // Init database (this must be done once).
        // Note that DaoMaster is generated only if there is at least one entity class!
        val helper = DaoMaster.DevOpenHelper(this, "notes-db", null)
        val db = helper.writableDatabase
        val daoMaster = DaoMaster(db)
        daoSession = daoMaster.newSession()
    }
}