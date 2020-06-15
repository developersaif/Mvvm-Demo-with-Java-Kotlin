package com.github.easymvvm.java.view_model;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.easymvvm.java.pojo_class.HolidayModel;
import com.github.easymvvm.java.repo.HolidayRepo;

/**
 * Created by Kashif on 9/27/2019.
 */
public class HolidayViewModel extends ViewModel {

    private HolidayRepo holidayRepo;
    private MutableLiveData<List<HolidayModel>> mutableLiveData;

    public HolidayViewModel(){
        holidayRepo = new HolidayRepo();
    }

    public LiveData<List<HolidayModel>> getHolidays() {
        if(mutableLiveData==null){
            mutableLiveData = holidayRepo.requestHolidays();
        }
        return mutableLiveData;
    }

}
