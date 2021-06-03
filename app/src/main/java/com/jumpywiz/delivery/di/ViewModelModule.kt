package com.jumpywiz.delivery.di

import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jumpywiz.delivery.presentation.viewmodel.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    internal abstract fun postListViewModel(viewModel: MenuViewModel): ViewModel

}