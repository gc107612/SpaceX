package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

@SuppressWarnings("unused")
public class PayloadsDTO implements Parcelable {

    public static final Creator<PayloadsDTO> CREATOR = new Creator<PayloadsDTO>() {
        @Override
        public PayloadsDTO createFromParcel(Parcel in) {
            return new PayloadsDTO(in);
        }

        @Override
        public PayloadsDTO[] newArray(int size) {
            return new PayloadsDTO[size];
        }
    };
    private String payload_id;
    private boolean reused;
    private String nationality;
    private String manufacturer;
    private String payload_type;
    private Double payload_mass_kg;
    private Double payload_mass_lbs;
    private String orbit;
    private OrbitParamsDTO orbit_params;
    private List<Integer> norad_id;
    private List<String> customers;

    private PayloadsDTO(Parcel in) {
        payload_id = in.readString();
        reused = in.readByte() != 0;
        nationality = in.readString();
        manufacturer = in.readString();
        payload_type = in.readString();
        if (in.readByte() == 0) {
            payload_mass_kg = null;
        } else {
            payload_mass_kg = in.readDouble();
        }
        if (in.readByte() == 0) {
            payload_mass_lbs = null;
        } else {
            payload_mass_lbs = in.readDouble();
        }
        orbit = in.readString();
        orbit_params = in.readParcelable(OrbitParamsDTO.class.getClassLoader());
        customers = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(payload_id);
        dest.writeByte((byte) (reused ? 1 : 0));
        dest.writeString(nationality);
        dest.writeString(manufacturer);
        dest.writeString(payload_type);
        if (payload_mass_kg == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(payload_mass_kg);
        }
        if (payload_mass_lbs == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(payload_mass_lbs);
        }
        dest.writeString(orbit);
        dest.writeParcelable(orbit_params, flags);
        dest.writeStringList(customers);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getPayload_id() {
        return payload_id;
    }

    public void setPayload_id(String payload_id) {
        this.payload_id = payload_id;
    }

    public boolean isReused() {
        return reused;
    }

    public void setReused(boolean reused) {
        this.reused = reused;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayload_type() {
        return payload_type;
    }

    public void setPayload_type(String payload_type) {
        this.payload_type = payload_type;
    }


    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParamsDTO getOrbit_params() {
        return orbit_params;
    }

    public void setOrbit_params(OrbitParamsDTO orbit_params) {
        this.orbit_params = orbit_params;
    }

    public List<Integer> getNorad_id() {
        return norad_id;
    }

    public void setNorad_id(List<Integer> norad_id) {
        this.norad_id = norad_id;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public Double getPayload_mass_kg() {
        return payload_mass_kg;
    }

    public void setPayload_mass_kg(Double payload_mass_kg) {
        this.payload_mass_kg = payload_mass_kg;
    }

    public Double getPayload_mass_lbs() {
        return payload_mass_lbs;
    }

    public void setPayload_mass_lbs(Double payload_mass_lbs) {
        this.payload_mass_lbs = payload_mass_lbs;
    }
}