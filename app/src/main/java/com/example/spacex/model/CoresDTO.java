package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("unused")
public class CoresDTO implements Parcelable {

    public static final Creator<CoresDTO> CREATOR = new Creator<CoresDTO>() {
        @Override
        public CoresDTO createFromParcel(Parcel in) {
            return new CoresDTO(in);
        }

        @Override
        public CoresDTO[] newArray(int size) {
            return new CoresDTO[size];
        }
    };

    /**
     * core_serial : Merlin1A
     * flight : 1
     * block : null
     * gridfins : false
     * legs : false
     * reused : false
     * land_success : null
     * landing_intent : false
     * landing_type : null
     * landing_vehicle : null
     */

    private String core_serial;
    private int flight;
    private int block;
    private Boolean gridfins;
    private Boolean legs;
    private Boolean reused;
    private Boolean land_success;
    private Boolean landing_intent;
    private String landing_type;
    private String landing_vehicle;

    private CoresDTO(Parcel in) {
        core_serial = in.readString();
        flight = in.readInt();
        block = in.readInt();
        byte tmpGridfins = in.readByte();
        gridfins = tmpGridfins == 0 ? null : tmpGridfins == 1;
        byte tmpLegs = in.readByte();
        legs = tmpLegs == 0 ? null : tmpLegs == 1;
        byte tmpReused = in.readByte();
        reused = tmpReused == 0 ? null : tmpReused == 1;
        byte tmpLand_success = in.readByte();
        land_success = tmpLand_success == 0 ? null : tmpLand_success == 1;
        byte tmpLanding_intent = in.readByte();
        landing_intent = tmpLanding_intent == 0 ? null : tmpLanding_intent == 1;
        landing_type = in.readString();
        landing_vehicle = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(core_serial);
        dest.writeInt(flight);
        dest.writeInt(block);
        dest.writeByte((byte) (gridfins == null ? 0 : gridfins ? 1 : 2));
        dest.writeByte((byte) (legs == null ? 0 : legs ? 1 : 2));
        dest.writeByte((byte) (reused == null ? 0 : reused ? 1 : 2));
        dest.writeByte((byte) (land_success == null ? 0 : land_success ? 1 : 2));
        dest.writeByte((byte) (landing_intent == null ? 0 : landing_intent ? 1 : 2));
        dest.writeString(landing_type);
        dest.writeString(landing_vehicle);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getCore_serial() {
        return core_serial;
    }

    public void setCore_serial(String core_serial) {
        this.core_serial = core_serial;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public Boolean getGridfins() {
        return gridfins;
    }

    public void setGridfins(Boolean gridfins) {
        this.gridfins = gridfins;
    }

    public Boolean getLegs() {
        return legs;
    }

    public void setLegs(Boolean legs) {
        this.legs = legs;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getLand_success() {
        return land_success;
    }

    public void setLand_success(Boolean land_success) {
        this.land_success = land_success;
    }

    public Boolean getLanding_intent() {
        return landing_intent;
    }

    public void setLanding_intent(Boolean landing_intent) {
        this.landing_intent = landing_intent;
    }

    public String getLanding_type() {
        return landing_type;
    }

    public void setLanding_type(String landing_type) {
        this.landing_type = landing_type;
    }

    public String getLanding_vehicle() {
        return landing_vehicle;
    }

    public void setLanding_vehicle(String landing_vehicle) {
        this.landing_vehicle = landing_vehicle;
    }
}
