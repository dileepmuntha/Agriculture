package com.example.a1234.agriculture;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class DataViewModel extends AndroidViewModel {
    DataRepository repository;
    LiveData<List<Sheet1>> listLiveData;


    List<Sheet1> list ;
    public DataViewModel(@NonNull Application application) {
        super(application);
        repository = new DataRepository(application);
        listLiveData = repository.getListOfData();
        list = repository.getList();
    }
    public LiveData<List<Sheet1>> getListLiveData() {
        return listLiveData;
    }

    public List<Sheet1> getList() {
        return list;
    }

    public void insertData(Sheet1 sheet1){
        repository.insertData(sheet1);
    }
}
