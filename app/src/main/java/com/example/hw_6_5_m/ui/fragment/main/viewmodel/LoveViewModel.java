package com.example.hw_6_5_m.ui.fragment.main.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.hw_6_5_m.data.entity.LoveModel;
import com.example.hw_6_5_m.data.repo.PixaBayRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoveViewModel extends ViewModel {

    PixaBayRepository repository;

    @Inject
    public LoveViewModel(PixaBayRepository repository) {
        this.repository = repository;
    }

    public LiveData<LoveModel> getModel(String firstName, String secondName){
        return repository.getModel(firstName, secondName);
    }
}
