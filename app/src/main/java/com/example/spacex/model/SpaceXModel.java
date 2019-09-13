package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@SuppressWarnings("unused")
public class SpaceXModel implements Parcelable {

    public static final Creator<SpaceXModel> CREATOR = new Creator<SpaceXModel>() {
        @Override
        public SpaceXModel createFromParcel(Parcel in) {
            return new SpaceXModel(in);
        }

        @Override
        public SpaceXModel[] newArray(int size) {
            return new SpaceXModel[size];
        }
    };

    private Integer flight_number;
    private String mission_name;
    private Boolean upcoming;
    private String launch_year;
    private Integer launch_date_unix;
    private String launch_date_utc;
    private String launch_date_local;
    private Boolean is_tentative;
    private String tentative_max_precision;
    private Boolean tbd;
    private Integer launch_window;
    private RocketDTO rocket;
    private TelemetryDTO telemetry;
    private LaunchSiteDTO launch_site;
    private Boolean launch_success;
    private LaunchFailureDetailsDTO launch_failure_details;
    private LinksDTO links;
    private String details;
    private String static_fire_date_utc;
    private Integer static_fire_date_unix;
    private TimelineDTO timeline;
    private Object crew;
    private List<String> mission_id;
    private List<String> ships;

    public SpaceXModel() {
    }

    protected SpaceXModel(Parcel in) {
        if (in.readByte() == 0) {
            flight_number = null;
        } else {
            flight_number = in.readInt();
        }
        mission_name = in.readString();
        byte tmpUpcoming = in.readByte();
        upcoming = tmpUpcoming == 0 ? null : tmpUpcoming == 1;
        launch_year = in.readString();
        if (in.readByte() == 0) {
            launch_date_unix = null;
        } else {
            launch_date_unix = in.readInt();
        }
        launch_date_utc = in.readString();
        launch_date_local = in.readString();
        byte tmpIs_tentative = in.readByte();
        is_tentative = tmpIs_tentative == 0 ? null : tmpIs_tentative == 1;
        tentative_max_precision = in.readString();
        byte tmpTbd = in.readByte();
        tbd = tmpTbd == 0 ? null : tmpTbd == 1;
        if (in.readByte() == 0) {
            launch_window = null;
        } else {
            launch_window = in.readInt();
        }
        rocket = in.readParcelable(RocketDTO.class.getClassLoader());
        telemetry = in.readParcelable(TelemetryDTO.class.getClassLoader());
        launch_site = in.readParcelable(LaunchSiteDTO.class.getClassLoader());
        byte tmpLaunch_success = in.readByte();
        launch_success = tmpLaunch_success == 0 ? null : tmpLaunch_success == 1;
        launch_failure_details = in.readParcelable(LaunchFailureDetailsDTO.class.getClassLoader());
        links = in.readParcelable(LinksDTO.class.getClassLoader());
        details = in.readString();
        static_fire_date_utc = in.readString();
        if (in.readByte() == 0) {
            static_fire_date_unix = null;
        } else {
            static_fire_date_unix = in.readInt();
        }
        timeline = in.readParcelable(TimelineDTO.class.getClassLoader());
        mission_id = in.createStringArrayList();
        ships = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (flight_number == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(flight_number);
        }
        dest.writeString(mission_name);
        dest.writeByte((byte) (upcoming == null ? 0 : upcoming ? 1 : 2));
        dest.writeString(launch_year);
        if (launch_date_unix == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(launch_date_unix);
        }
        dest.writeString(launch_date_utc);
        dest.writeString(launch_date_local);
        dest.writeByte((byte) (is_tentative == null ? 0 : is_tentative ? 1 : 2));
        dest.writeString(tentative_max_precision);
        dest.writeByte((byte) (tbd == null ? 0 : tbd ? 1 : 2));
        if (launch_window == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(launch_window);
        }
        dest.writeParcelable(rocket, flags);
        dest.writeParcelable(telemetry, flags);
        dest.writeParcelable(launch_site, flags);
        dest.writeByte((byte) (launch_success == null ? 0 : launch_success ? 1 : 2));
        dest.writeParcelable(launch_failure_details, flags);
        dest.writeParcelable(links, flags);
        dest.writeString(details);
        dest.writeString(static_fire_date_utc);
        if (static_fire_date_unix == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(static_fire_date_unix);
        }
        dest.writeParcelable(timeline, flags);
        dest.writeStringList(mission_id);
        dest.writeStringList(ships);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Integer getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(Integer flight_number) {
        this.flight_number = flight_number;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getLaunch_year() {
        return launch_year;
    }

    public void setLaunch_year(String launch_year) {
        this.launch_year = launch_year;
    }

    public Integer getLaunch_date_unix() {
        return launch_date_unix;
    }

    public void setLaunch_date_unix(Integer launch_date_unix) {
        this.launch_date_unix = launch_date_unix;
    }

    public String getLaunch_date_utc() {
        return launch_date_utc;
    }

    public void setLaunch_date_utc(String launch_date_utc) {
        this.launch_date_utc = launch_date_utc;
    }

    public String getLaunch_date_local() {
        return launch_date_local;
    }

    public void setLaunch_date_local(String launch_date_local) {
        this.launch_date_local = launch_date_local;
    }

    public Boolean getIs_tentative() {
        return is_tentative;
    }

    public void setIs_tentative(Boolean is_tentative) {
        this.is_tentative = is_tentative;
    }

    public String getTentative_max_precision() {
        return tentative_max_precision;
    }

    public void setTentative_max_precision(String tentative_max_precision) {
        this.tentative_max_precision = tentative_max_precision;
    }

    public Boolean getTbd() {
        return tbd;
    }

    public void setTbd(Boolean tbd) {
        this.tbd = tbd;
    }

    public Integer getLaunch_window() {
        return launch_window;
    }

    public void setLaunch_window(Integer launch_window) {
        this.launch_window = launch_window;
    }

    public RocketDTO getRocket() {
        return rocket;
    }

    public void setRocket(RocketDTO rocket) {
        this.rocket = rocket;
    }

    public TelemetryDTO getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(TelemetryDTO telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSiteDTO getLaunch_site() {
        return launch_site;
    }

    public void setLaunch_site(LaunchSiteDTO launch_site) {
        this.launch_site = launch_site;
    }

    public Boolean getLaunch_success() {
        return launch_success;
    }

    public void setLaunch_success(Boolean launch_success) {
        this.launch_success = launch_success;
    }

    public LaunchFailureDetailsDTO getLaunch_failure_details() {
        return launch_failure_details;
    }

    public void setLaunch_failure_details(LaunchFailureDetailsDTO launch_failure_details) {
        this.launch_failure_details = launch_failure_details;
    }

    public LinksDTO getLinks() {
        return links;
    }

    public void setLinks(LinksDTO links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatic_fire_date_utc() {
        return static_fire_date_utc;
    }

    public void setStatic_fire_date_utc(String static_fire_date_utc) {
        this.static_fire_date_utc = static_fire_date_utc;
    }

    public Integer getStatic_fire_date_unix() {
        return static_fire_date_unix;
    }

    public void setStatic_fire_date_unix(Integer static_fire_date_unix) {
        this.static_fire_date_unix = static_fire_date_unix;
    }

    public TimelineDTO getTimeline() {
        return timeline;
    }

    public void setTimeline(TimelineDTO timeline) {
        this.timeline = timeline;
    }

    public Object getCrew() {
        return crew;
    }

    public void setCrew(Object crew) {
        this.crew = crew;
    }

    public List<String> getMission_id() {
        return mission_id;
    }

    public void setMission_id(List<String> mission_id) {
        this.mission_id = mission_id;
    }

    public List<String> getShips() {
        return ships;
    }

    public void setShips(List<String> ships) {
        this.ships = ships;
    }

    @Override
    public String toString() {
        return "SpaceXModel{" +
                "flight_number=" + flight_number +
                ", mission_name='" + mission_name + '\'' +
                ", upcoming=" + upcoming +
                ", launch_year='" + launch_year + '\'' +
                ", launch_date_unix=" + launch_date_unix +
                ", launch_date_utc='" + launch_date_utc + '\'' +
                ", launch_date_local='" + launch_date_local + '\'' +
                ", is_tentative=" + is_tentative +
                ", tentative_max_precision='" + tentative_max_precision + '\'' +
                ", tbd=" + tbd +
                ", launch_window=" + launch_window +
                ", rocket=" + rocket +
                ", telemetry=" + telemetry +
                ", launch_site=" + launch_site +
                ", launch_success=" + launch_success +
                ", launch_failure_details=" + launch_failure_details +
                ", links=" + links +
                ", details='" + details + '\'' +
                ", static_fire_date_utc='" + static_fire_date_utc + '\'' +
                ", static_fire_date_unix=" + static_fire_date_unix +
                ", timeline=" + timeline +
                ", crew=" + crew +
                ", mission_id=" + mission_id +
                ", ships=" + ships +
                '}';
    }

}