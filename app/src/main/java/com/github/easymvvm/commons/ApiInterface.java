package com.github.easymvvm.commons;

import com.github.easymvvm.java.pojo_class.HolidayModel;
import com.github.easymvvm.kotlin.HolidayModelKotlin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by saif on 9/27/2019.
 */
public interface ApiInterface {

    @GET("menu.php")
    Call<List<HolidayModel>> getHolidays();

    @GET("menu.php")
    Call<List<HolidayModelKotlin>> getHolidaysKotlin();

}
