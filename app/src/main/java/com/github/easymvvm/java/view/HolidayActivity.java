package com.github.easymvvm.java.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.github.easymvvm.R;
import com.github.easymvvm.commons.MyApplication;

import com.github.easymvvm.databinding.ActivityHolidayBinding;
import com.github.easymvvm.java.view_model.HolidayViewModel;
import com.github.easymvvm.java.click_listner.MClickListener;
import com.github.easymvvm.java.adapter.HolidayAdapter;
import com.github.easymvvm.java.pojo_class.HolidayModel;

import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

public class HolidayActivity extends AppCompatActivity implements MClickListener {

    final String TAG = getClass().getSimpleName();
    ActivityHolidayBinding binding;
    HolidayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_holiday);
        initUI();

        if(MyApplication.getInstance().isNetworkAvailable()) {
            binding.progressBar.setVisibility(View.VISIBLE);

            HolidayViewModel holidayViewModel = new HolidayViewModel();
            holidayViewModel.getHolidays().observe(this, new Observer<List<HolidayModel>>() {
                @Override
                public void onChanged(List<HolidayModel> currencyPojos) {
                    if (currencyPojos != null && !currencyPojos.isEmpty()) {
                        Log.e(TAG, "observe onChanged()=" + currencyPojos.size());
                        binding.progressBar.setVisibility(View.GONE);
                        adapter.addHolidayList(currencyPojos);
                        adapter.notifyDataSetChanged();
                    }
                }
            });

        }else{
            Toast.makeText(this, "No Network Available", Toast.LENGTH_LONG).show();
        }
    }

    void initUI(){

        binding.rvHolidayList.setHasFixedSize(true);
        binding.rvHolidayList.setLayoutManager(new LinearLayoutManager(this));


        adapter = new HolidayAdapter(this);
        binding.rvHolidayList.setAdapter(adapter);
    }


    @Override
    public void mClick1(HolidayModel holidayModels) {

        Toast.makeText(getApplicationContext(), ""+holidayModels.getName(),  Toast.LENGTH_SHORT).show();
        Log.e("res",""+holidayModels.getName());
        Log.e("res",""+holidayModels.getDate());
    }
}
