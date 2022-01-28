package com.example.citygym.ui.hometrainers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeTrainersViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeTrainersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}