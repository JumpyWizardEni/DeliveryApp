package com.jumpywiz.delivery.di

import android.view.View
import com.jumpywiz.delivery.presentation.ui.MainActivity
import com.jumpywiz.delivery.presentation.viewmodel.MenuViewModel
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = arrayOf(
        AppModule::class,
        DatabaseModule::class,
        RemoteModule::class,
        ReposModule::class,
        ViewModelModule::class
    )
)
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(viewModel: MenuViewModel)
}