package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("unused")
public class LaunchFailureDetailsDTO implements Parcelable {

    public static final Creator<LaunchFailureDetailsDTO> CREATOR = new Creator<LaunchFailureDetailsDTO>() {
        @Override
        public LaunchFailureDetailsDTO createFromParcel(Parcel in) {
            return new LaunchFailureDetailsDTO(in);
        }

        @Override
        public LaunchFailureDetailsDTO[] newArray(int size) {
            return new LaunchFailureDetailsDTO[size];
        }
    };

    private int time;
    private Double altitude;
    private String reason;

    private LaunchFailureDetailsDTO(Parcel in) {
        time = in.readInt();
        if (in.readByte() == 0) {
            altitude = null;
        } else {
            altitude = in.readDouble();
        }
        reason = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(time);
        if (altitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(altitude);
        }
        dest.writeString(reason);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
