package com.asmaulhusna.core

import androidx.room.Room
import com.asmaulhusna.core.data.AsmaulHusnaRepository
import com.asmaulhusna.core.data.SettingsRepository
import com.asmaulhusna.core.data.local.DataStoreSource
import com.asmaulhusna.core.data.local.room.AsmaulHusnaDatabase
import com.asmaulhusna.core.data.remote.network.ApiService
import com.asmaulhusna.core.domain.repository.IAsmaulHusnaRepository
import com.asmaulhusna.core.domain.repository.ISettingsRepository
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
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
        val passphrase: ByteArray = SQLiteDatabase.getBytes("asmaulhusna".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(), AsmaulHusnaDatabase::class.java, "AsmaulHusna"
        ).openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "islamic-api-zhirrr.vercel.app"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/8oTTIaobTfGy0BpRmvIHeXMdSpyRJdC9vuqLAxbodqM=")
            .add(hostname, "sha256/K7rZOrXHknnsEhUH8nLL4MZkejquUuIvOIr6tCa0rbo=")
            .add(hostname, "sha256/lpZ7tcVwmwQIMcRtPbsQtWLABXhQzejna0wHFr8M=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
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