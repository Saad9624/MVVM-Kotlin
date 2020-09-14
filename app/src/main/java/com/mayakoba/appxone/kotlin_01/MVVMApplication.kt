package com.mayakoba.appxone.kotlin_01

import android.app.Application
import com.mayakoba.appxone.kotlin_01.data.db.AppDatabase
import com.mayakoba.appxone.kotlin_01.data.repository.UserRepository
import com.mayakoba.appxone.kotlin_01.data.service.Api
import com.mayakoba.appxone.kotlin_01.data.service.NetworkConnectionInterceptor
import com.mayakoba.appxone.kotlin_01.views.auth.AuthViewModelFactory
import com.mayakoba.appxone.kotlin_01.views.auth.ProfileModelFactory
import com.mayakoba.appxone.kotlin_01.views.auth.fragments.ProfileViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * APPLICATION CLASS
 * it is a base class and it is instantiated before any thing else
 * and inside this class we use kodein to generate dependency and required object
 */

class MVVMApplication : Application() , KodeinAware {

    /**
     * Let's summarize lazy() in the Kotlin standard library reference as follows:
     * lazy() returns a Lazy<T> instance that stored lambda initializer.
     * The first call of getter executes a lambda passed to lazy() and stores its result.
     * Subsequently, the getter execution returns the stored value
     */


    override val kodein =  Kodein.lazy {

        import(androidXModule(this@MVVMApplication))

        /**
         * Singleton means we want to create only single instance
         */


        /**
         * instance() mean take the instance of respective class but
         * respective class must be instantiated already
         */
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { Api(instance()) }
        bind() from singleton { AppDatabase(instance())  }
        bind() from singleton { UserRepository(instance(),instance()) }
        bind() from provider { AuthViewModelFactory(instance())}
        bind() from provider { ProfileModelFactory(instance())}

    }

}