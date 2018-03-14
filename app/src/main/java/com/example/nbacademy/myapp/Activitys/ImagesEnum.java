package com.example.nbacademy.myapp.Activitys;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nbacademy on 09/03/2018.
 */
public enum ImagesEnum implements Parcelable {
    Lisbon {
        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
dest.writeString("Lisbon");
        }
    }, Marrocos {
        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString("Marrocos");
        }
    }
}
