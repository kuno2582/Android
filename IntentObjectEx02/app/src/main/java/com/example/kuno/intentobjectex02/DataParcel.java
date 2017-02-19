package com.example.kuno.intentobjectex02;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kuno on 2017-02-01.
 */

public class DataParcel implements Parcelable {

    String name;
    int age;
    String address;

    public DataParcel(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    protected DataParcel(Parcel in) {
    }

    public static final Creator<DataParcel> CREATOR = new Creator<DataParcel>() {
        @Override
        public DataParcel createFromParcel(Parcel in) {
            //return new DataParcel(in);
            String name = in.readString();
            int age = in.readInt();
            String address = in.readString();
            return new DataParcel(name, age, address);
        }

        @Override
        public DataParcel[] newArray(int size) {
            return new DataParcel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(address);
    }
}
