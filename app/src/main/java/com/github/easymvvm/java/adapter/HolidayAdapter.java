package com.github.easymvvm.java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.easymvvm.R;
import com.github.easymvvm.databinding.ItemHolidayJavaBinding;
import com.github.easymvvm.java.view.HolidayActivity;
import com.github.easymvvm.java.pojo_class.HolidayModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Kashif on 9/30/2019.
 */
public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.MyViewHolder> {

    private List<HolidayModel> holidayList;
    public HolidayActivity activity = new HolidayActivity();
    private Context context;

    public HolidayAdapter(Context context) {
        this.context = context;
        holidayList = new ArrayList<>();
    }

    public void addHolidayList(List<HolidayModel> currencyList) {
        this.holidayList = currencyList;
    }

    @Override
    public int getItemCount() {
        return holidayList != null ? holidayList.size() : 0;
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        ItemHolidayJavaBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_holiday_java, parent, false);

        return new MyViewHolder(binding);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemHolidayJavaBinding binding;


        MyViewHolder(ItemHolidayJavaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.binding.setModel(holidayList.get(position));
        holder.binding.setAct((HolidayActivity) context);

       /* holder.binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.mClick1(holidayList,position);
            }
        });*/

    }

}
