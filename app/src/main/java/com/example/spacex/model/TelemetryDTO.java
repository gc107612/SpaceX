package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("unused")
public class TelemetryDTO implements Parcelable {

    public static final Creator<TelemetryDTO> CREATOR = new Creator<TelemetryDTO>() {
        @Override
        public TelemetryDTO createFromParcel(Parcel in) {
            return new TelemetryDTO(in);
        }

        @Override
        public TelemetryDTO[] newArray(int size) {
            return new TelemetryDTO[size];
        }
    };
    private String flight_club;

    private TelemetryDTO(Parcel in) {
        flight_club = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(flight_club);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getFlight_club() {
        return flight_club;
    }

    public void setFlight_club(String flight_club) {
        this.flight_club = flight_club;
    }
}