package com.asmaulhusna.core

import androidx.room.Room
import com.asmaulhusna.core.data.AsmaulHusnaRepository
import com.asmaulhusna.core.data.SettingsRepository
import com.asmaulhusna.core.data.local.DataStoreSource
import com.asmaulhusna.core.data.local.room.AsmaulHusnaDatabase
import com.asmaulhusna.core.data.remote.network.ApiService
import com.asmaulhusna.core.domain.repository.IAsmaulHusnaRepository
import com.asmaulhusna.core.domain.repository.ISettingsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { DataStoreSource(get()) }
    factory { get<AsmaulHusnaDatabase>().asmaulHusnaDao() }
    single {
        Room.databaseBuilder(
            androidContext(), AsmaulHusnaDatabase::class.java, "AsmaulHusna.db"
        ).build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://islamic-api-zhirrr.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModel = module {
    single<ISettingsRepository> { SettingsRepository(get()) }
    single<IAsmaulHusnaRepository> { AsmaulHusnaRepository(get(), get()) }
}