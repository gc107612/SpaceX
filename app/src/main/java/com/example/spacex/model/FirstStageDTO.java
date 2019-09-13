package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

@SuppressWarnings("unused")
public class FirstStageDTO implements Parcelable {

    public static final Creator<FirstStageDTO> CREATOR = new Creator<FirstStageDTO>() {
        @Override
        public FirstStageDTO createFromParcel(Parcel in) {
            return new FirstStageDTO(in);
        }

        @Override
        public FirstStageDTO[] newArray(int size) {
            return new FirstStageDTO[size];
        }
    };
    private List<CoresDTO> cores;

    private FirstStageDTO(Parcel in) {
        cores = in.createTypedArrayList(CoresDTO.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(cores);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public List<CoresDTO> getCores() {
        return cores;
    }

    public void setCores(List<CoresDTO> cores) {
        this.cores = cores;
    }
}
