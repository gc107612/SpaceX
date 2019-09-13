package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("unused")
public class LaunchSiteDTO implements Parcelable {

    public static final Creator<LaunchSiteDTO> CREATOR = new Creator<LaunchSiteDTO>() {
        @Override
        public LaunchSiteDTO createFromParcel(Parcel in) {
            return new LaunchSiteDTO(in);
        }

        @Override
        public LaunchSiteDTO[] newArray(int size) {
            return new LaunchSiteDTO[size];
        }
    };
    /**
     * site_id : kwajalein_atoll
     * site_name : Kwajalein Atoll
     * site_name_long : Kwajalein Atoll Omelek Island
     */

    private String site_id;
    private String site_name;
    private String site_name_long;

    private LaunchSiteDTO(Parcel in) {
        site_id = in.readString();
        site_name = in.readString();
        site_name_long = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(site_id);
        dest.writeString(site_name);
        dest.writeString(site_name_long);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getSite_name_long() {
        return site_name_long;
    }

    public void setSite_name_long(String site_name_long) {
        this.site_name_long = site_name_long;
    }
}
