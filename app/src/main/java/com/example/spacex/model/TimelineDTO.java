package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("unused")
public class TimelineDTO implements Parcelable {
    public static final Creator<TimelineDTO> CREATOR = new Creator<TimelineDTO>() {
        @Override
        public TimelineDTO createFromParcel(Parcel in) {
            return new TimelineDTO(in);
        }

        @Override
        public TimelineDTO[] newArray(int size) {
            return new TimelineDTO[size];
        }
    };

    private int webcast_liftoff;

    private TimelineDTO(Parcel in) {
        webcast_liftoff = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(webcast_liftoff);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getWebcast_liftoff() {
        return webcast_liftoff;
    }

    public void setWebcast_liftoff(int webcast_liftoff) {
        this.webcast_liftoff = webcast_liftoff;
    }
}