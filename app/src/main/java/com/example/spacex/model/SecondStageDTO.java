package com.example.spacex.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

@SuppressWarnings("unused")
public class SecondStageDTO implements Parcelable {

    private Double block;
    private List<PayloadsDTO> payloads;

    private SecondStageDTO(Parcel in) {
        if (in.readByte() == 0) {
            block = null;
        } else {
            block = in.readDouble();
        }
        payloads = in.createTypedArrayList(PayloadsDTO.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (block == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(block);
        }
        dest.writeTypedList(payloads);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SecondStageDTO> CREATOR = new Creator<SecondStageDTO>() {
        @Override
        public SecondStageDTO createFromParcel(Parcel in) {
            return new SecondStageDTO(in);
        }

        @Override
        public SecondStageDTO[] newArray(int size) {
            return new SecondStageDTO[size];
        }
    };

    public Double getBlock() {
        return block;
    }

    public void setBlock(Double block) {
        this.block = block;
    }

    public List<PayloadsDTO> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<PayloadsDTO> payloads) {
        this.payloads = payloads;
    }
}