package com.example.spacex.util;

import android.content.Context;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spacex.R;
import com.example.spacex.model.SpaceXModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class Utils {

    public static String dateFormatYYYYMMDD = "yyyy-MM-dd";
    public static String dateFormatUTC = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";


    @BindingAdapter({"app:adapter", "app:data"})
    public static <T extends CustomRecyclerViewAdapter> void bind(RecyclerView recyclerView, T adapter, List data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }

    @BindingAdapter({"app:adapter", "app:data"})
    public static <T extends CustomRecyclerViewAdapter> void bind(RecyclerView recyclerView, T adapter, MutableLiveData<List> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data.getValue());
    }

    public static <T extends ViewModel> T obtainViewModel(AppCompatActivity activity, Class<T> type) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance();
        factory.setApplication(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(type);
    }

    public static void loadImageParticipant(Context context, String imageUrl, ImageView imageView) {
        Glide.with(context)
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.mipmap.flight)
                .into(imageView);
    }

    @BindingAdapter({"app:imageUrl", "app:context"})
    public static void loadImage(ImageView imageView, String imageUrl, Context context) {
        loadImageParticipant(context, imageUrl, imageView);
    }

    private static Date convertToNewFormat(String dateStr) throws ParseException {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        sourceFormat.setTimeZone(utc);
        return sourceFormat.parse(dateStr);
    }

    public static void sortDataByUTC(ArrayList<SpaceXModel> data) {
        Collections.sort(data, (o1, o2) -> {
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = convertToNewFormat(o1.getLaunch_date_utc());
                date2 = convertToNewFormat(o2.getLaunch_date_utc());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date1 != null && date2 != null)
                return date2.compareTo(date1);
            return 0;
        });
    }
}