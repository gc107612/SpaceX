package com.example.spacex.viewmodel.spacexdetails;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.spacex.model.SpaceXModel;
import com.example.spacex.util.Utils;
import com.example.spacex.viewmodel.CustomViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SpaceXDetailsViewModel extends CustomViewModel {

    public Context mContext;
    private SpaceXModel selectedData;

    public SpaceXDetailsViewModel(@NonNull Application application) {
        super(application);
        mContext = application.getApplicationContext();

    }

    public SpaceXModel getSelectedData() {
        return selectedData;
    }

    public void setSelectedData(SpaceXModel selectedData) {
        this.selectedData = selectedData;
    }

    public String getFormatedDate() {
        SimpleDateFormat inputFormat = new SimpleDateFormat(Utils.dateFormatUTC);
        SimpleDateFormat outputFormat = new SimpleDateFormat(Utils.dateFormatYYYYMMDD);
        Date date = null;
        try {
            date = inputFormat.parse(selectedData.getLaunch_date_utc());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputFormat.format(date);

    }
}
