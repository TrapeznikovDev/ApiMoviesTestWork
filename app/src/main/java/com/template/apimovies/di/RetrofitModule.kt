package com.template.apimovies.di

import android.annotation.SuppressLint
import android.content.Context
import com.template.apimovies.di.retrofit.Api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.template.apimovies.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@Module
class RetrofitModule(retroContext: Context) {

    var context = retroContext

    @Provides
    @Singleton
    fun provideHttpLogging(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        val interceptor = HttpLoggingInterceptor()
        val trustAllCerts = arrayOf<TrustManager>(@SuppressLint("CustomX509TrustManager")
        object : X509TrustManager {
            @SuppressLint("TrustAllX509TrustManager")
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }
            @SuppressLint("TrustAllX509TrustManager")
            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            }
            override fun getAcceptedIssuers() = arrayOf<X509Certificate>()
        })
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
        val sslSocketFactory = sslContext.socketFactory
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder()

            .addInterceptor(logging)
            .addInterceptor(interceptor).sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager).connectTimeout(
                60,
                java.util.concurrent.TimeUnit.SECONDS)

            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Api = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(Api::class.java)

//    @Provides
//    @Singleton
//    fun provideApiService(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    @Provides
    @Singleton
    fun providesConverterFactory(gson: Gson):Converter.Factory{
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideGsonBuilder(): Gson{
        return GsonBuilder().create()
    }

}