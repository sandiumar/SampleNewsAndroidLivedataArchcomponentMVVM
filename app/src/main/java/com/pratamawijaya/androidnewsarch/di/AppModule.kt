package com.pratamawijaya.androidnewsarch.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.pratamawijaya.androidnewsarch.data.db.AndroidNewsDb
import com.pratamawijaya.androidnewsarch.data.db.ArticleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: Application): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideDb(app: Application): AndroidNewsDb {
        return Room.databaseBuilder(app, AndroidNewsDb::class.java, "androidnewsmvvm.db")
                .build()
    }

    @Singleton
    @Provides
    fun provideArticleDao(db: AndroidNewsDb): ArticleDao {
        return db.articleDao()
    }

}