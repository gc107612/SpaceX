package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("unused")
public class RocketDTO implements Parcelable {

    public static final Creator<RocketDTO> CREATOR = new Creator<RocketDTO>() {
        @Override
        public RocketDTO createFromParcel(Parcel in) {
            return new RocketDTO(in);
        }

        @Override
        public RocketDTO[] newArray(int size) {
            return new RocketDTO[size];
        }
    };
    private String rocket_id;
    private String rocket_name;
    private String rocket_type;
    private FirstStageDTO first_stage;
    private SecondStageDTO second_stage;
    private FairingsDTO fairings;

    private RocketDTO(Parcel in) {
        rocket_id = in.readString();
        rocket_name = in.readString();
        rocket_type = in.readString();
        first_stage = in.readParcelable(FirstStageDTO.class.getClassLoader());
        second_stage = in.readParcelable(SecondStageDTO.class.getClassLoader());
        fairings = in.readParcelable(FairingsDTO.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rocket_id);
        dest.writeString(rocket_name);
        dest.writeString(rocket_type);
        dest.writeParcelable(first_stage, flags);
        dest.writeParcelable(second_stage, flags);
        dest.writeParcelable(fairings, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getRocket_id() {
        return rocket_id;
    }

    public void setRocket_id(String rocket_id) {
        this.rocket_id = rocket_id;
    }

    public String getRocket_name() {
        return rocket_name;
    }

    public void setRocket_name(String rocket_name) {
        this.rocket_name = rocket_name;
    }

    public String getRocket_type() {
        return rocket_type;
    }

    public void setRocket_type(String rocket_type) {
        this.rocket_type = rocket_type;
    }

    public FirstStageDTO getFirst_stage() {
        return first_stage;
    }

    public void setFirst_stage(FirstStageDTO first_stage) {
        this.first_stage = first_stage;
    }

    public SecondStageDTO getSecond_stage() {
        return second_stage;
    }

    public void setSecond_stage(SecondStageDTO second_stage) {
        this.second_stage = second_stage;
    }

    public FairingsDTO getFairings() {
        return fairings;
    }

    public void setFairings(FairingsDTO fairings) {
        this.fairings = fairings;
    }
}