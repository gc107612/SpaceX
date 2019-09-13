package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("unused")
public class OrbitParamsDTO implements Parcelable {
    public static final Creator<OrbitParamsDTO> CREATOR = new Creator<OrbitParamsDTO>() {
        @Override
        public OrbitParamsDTO createFromParcel(Parcel in) {
            return new OrbitParamsDTO(in);
        }

        @Override
        public OrbitParamsDTO[] newArray(int size) {
            return new OrbitParamsDTO[size];
        }
    };

    private String reference_system;
    private String regime;
    private Double longitude;
    private Double semi_major_axis_km;
    private Double eccentricity;
    private Double periapsis_km;
    private Double apoapsis_km;
    private Double inclination_deg;
    private Double period_min;
    private Double lifespan_years;
    private String epoch;
    private Double mean_motion;
    private Double raan;
    private Double arg_of_pericenter;
    private Double mean_anomaly;

    private OrbitParamsDTO(Parcel in) {
        reference_system = in.readString();
        regime = in.readString();
        if (in.readByte() == 0) {
            longitude = null;
        } else {
            longitude = in.readDouble();
        }
        if (in.readByte() == 0) {
            semi_major_axis_km = null;
        } else {
            semi_major_axis_km = in.readDouble();
        }
        if (in.readByte() == 0) {
            eccentricity = null;
        } else {
            eccentricity = in.readDouble();
        }
        if (in.readByte() == 0) {
            periapsis_km = null;
        } else {
            periapsis_km = in.readDouble();
        }
        if (in.readByte() == 0) {
            apoapsis_km = null;
        } else {
            apoapsis_km = in.readDouble();
        }
        if (in.readByte() == 0) {
            inclination_deg = null;
        } else {
            inclination_deg = in.readDouble();
        }
        if (in.readByte() == 0) {
            period_min = null;
        } else {
            period_min = in.readDouble();
        }
        if (in.readByte() == 0) {
            lifespan_years = null;
        } else {
            lifespan_years = in.readDouble();
        }
        epoch = in.readString();
        if (in.readByte() == 0) {
            mean_motion = null;
        } else {
            mean_motion = in.readDouble();
        }
        if (in.readByte() == 0) {
            raan = null;
        } else {
            raan = in.readDouble();
        }
        if (in.readByte() == 0) {
            arg_of_pericenter = null;
        } else {
            arg_of_pericenter = in.readDouble();
        }
        if (in.readByte() == 0) {
            mean_anomaly = null;
        } else {
            mean_anomaly = in.readDouble();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(reference_system);
        dest.writeString(regime);
        if (longitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(longitude);
        }
        if (semi_major_axis_km == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(semi_major_axis_km);
        }
        if (eccentricity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(eccentricity);
        }
        if (periapsis_km == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(periapsis_km);
        }
        if (apoapsis_km == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(apoapsis_km);
        }
        if (inclination_deg == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(inclination_deg);
        }
        if (period_min == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(period_min);
        }
        if (lifespan_years == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(lifespan_years);
        }
        dest.writeString(epoch);
        if (mean_motion == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(mean_motion);
        }
        if (raan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(raan);
        }
        if (arg_of_pericenter == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(arg_of_pericenter);
        }
        if (mean_anomaly == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(mean_anomaly);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getReference_system() {
        return reference_system;
    }

    public void setReference_system(String reference_system) {
        this.reference_system = reference_system;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getSemi_major_axis_km() {
        return semi_major_axis_km;
    }

    public void setSemi_major_axis_km(Double semi_major_axis_km) {
        this.semi_major_axis_km = semi_major_axis_km;
    }

    public Double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Double getPeriapsis_km() {
        return periapsis_km;
    }

    public void setPeriapsis_km(Double periapsis_km) {
        this.periapsis_km = periapsis_km;
    }

    public Double getApoapsis_km() {
        return apoapsis_km;
    }

    public void setApoapsis_km(Double apoapsis_km) {
        this.apoapsis_km = apoapsis_km;
    }

    public Double getInclination_deg() {
        return inclination_deg;
    }

    public void setInclination_deg(Double inclination_deg) {
        this.inclination_deg = inclination_deg;
    }

    public Double getPeriod_min() {
        return period_min;
    }

    public void setPeriod_min(Double period_min) {
        this.period_min = period_min;
    }

    public Double getLifespan_years() {
        return lifespan_years;
    }

    public void setLifespan_years(Double lifespan_years) {
        this.lifespan_years = lifespan_years;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public Double getMean_motion() {
        return mean_motion;
    }

    public void setMean_motion(Double mean_motion) {
        this.mean_motion = mean_motion;
    }

    public Double getRaan() {
        return raan;
    }

    public void setRaan(Double raan) {
        this.raan = raan;
    }

    public Double getArg_of_pericenter() {
        return arg_of_pericenter;
    }

    public void setArg_of_pericenter(Double arg_of_pericenter) {
        this.arg_of_pericenter = arg_of_pericenter;
    }

    public Double getMean_anomaly() {
        return mean_anomaly;
    }

    public void setMean_anomaly(Double mean_anomaly) {
        this.mean_anomaly = mean_anomaly;
    }
}