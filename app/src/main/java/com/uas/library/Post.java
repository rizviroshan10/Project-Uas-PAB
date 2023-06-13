package com.uas.library;

import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {
    private String id;
    private String judul;
    private String user_id;
    private String deskripsi;
    private int jumlah;
    private String sampul;
    private String username;

    protected Post(Parcel in) {
        id = in.readString();
        judul = in.readString();
        user_id = in.readString();
        deskripsi = in.readString();
        jumlah = in.readInt();
        username = in.readString();
        sampul = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(judul);
        dest.writeString(user_id);
        dest.writeString(deskripsi);
        dest.writeInt(jumlah);
        dest.writeString(username);
        dest.writeString(sampul);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
    public String getSampul() {
        return sampul;
    }

    public void setSampul(String sampul) {
        this.sampul = sampul;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
