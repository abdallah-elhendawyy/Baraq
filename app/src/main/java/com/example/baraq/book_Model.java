package com.example.baraq;

import android.os.Parcel;
import android.os.Parcelable;

public class book_Model implements Parcelable {
    String title,image_url,decription,puplsher_name;
    int puplish_date,rting;


    public book_Model(String image_url, String puplsher_name) {
        this.image_url = image_url;
        this.puplsher_name = puplsher_name;
    }

    protected book_Model(Parcel in) {
        title = in.readString();
        image_url = in.readString();
        decription = in.readString();
        puplsher_name = in.readString();
        puplish_date = in.readInt();
        rting = in.readInt();
    }

    public static final Creator<book_Model> CREATOR = new Creator<book_Model>() {
        @Override
        public book_Model createFromParcel(Parcel in) {
            return new book_Model(in);
        }

        @Override
        public book_Model[] newArray(int size) {
            return new book_Model[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getPuplsher_name() {
        return puplsher_name;
    }

    public void setPuplsher_name(String puplsher_name) {
        this.puplsher_name = puplsher_name;
    }

    public int getPuplish_date() {
        return puplish_date;
    }

    public void setPuplish_date(int puplish_date) {
        this.puplish_date = puplish_date;
    }

    public int getRting() {
        return rting;
    }

    public void setRting(int rting) {
        this.rting = rting;
    }

    public book_Model(String title, String image_url, String decription, String puplsher_name, int puplish_date, int rting) {
        this.title = title;
        this.image_url = image_url;
        this.decription = decription;
        this.puplsher_name = puplsher_name;
        this.puplish_date = puplish_date;
        this.rting = rting;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(image_url);
        dest.writeString(decription);
        dest.writeString(puplsher_name);
        dest.writeInt(puplish_date);
        dest.writeInt(rting);
    }
}
