package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("unused")
public class FairingsDTO implements Parcelable {

    /**
     * reused : false
     * recovery_attempt : false
     * recovered : false
     * ship : null
     */

    private boolean reused;
    private boolean recovery_attempt;
    private boolean recovered;
    private String ship;


    private FairingsDTO(Parcel in) {
        reused = in.readByte() != 0;
        recovery_attempt = in.readByte() != 0;
        recovered = in.readByte() != 0;
        ship = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (reused ? 1 : 0));
        dest.writeByte((byte) (recovery_attempt ? 1 : 0));
        dest.writeByte((byte) (recovered ? 1 : 0));
        dest.writeString(ship);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FairingsDTO> CREATOR = new Creator<FairingsDTO>() {
        @Override
        public FairingsDTO createFromParcel(Parcel in) {
            return new FairingsDTO(in);
        }

        @Override
        public FairingsDTO[] newArray(int size) {
            return new FairingsDTO[size];
        }
    };

    public boolean isReused() {
        return reused;
    }

    public void setReused(boolean reused) {
        this.reused = reused;
    }

    public boolean isRecovery_attempt() {
        return recovery_attempt;
    }

    public void setRecovery_attempt(boolean recovery_attempt) {
        this.recovery_attempt = recovery_attempt;
    }

    public boolean isRecovered() {
        return recovered;
    }

    public void setRecovered(boolean recovered) {
        this.recovered = recovered;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }
}
