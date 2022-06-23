package com.template.apimovies.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final Map<Class<? extends ViewModel>,
            Provider<ViewModel>> viewModels;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>,
            Provider<ViewModel>> viewModels){
        this.viewModels = viewModels;
    }

    @Override
    public <T extends ViewModel> @NotNull T create(@NotNull Class<T> modeClass) {
        Provider<ViewModel> viewModelProvider = viewModels.get(modeClass);

        if(viewModelProvider == null){
            throw new IllegalArgumentException("mode class"
            +modeClass
            +"not found");
        }
        return (T) viewModelProvider.get();
    }
}
