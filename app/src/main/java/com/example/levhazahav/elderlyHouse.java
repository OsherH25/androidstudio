package com.example.levhazahav;

import com.google.android.gms.maps.model.LatLng;

public class elderlyHouse {


    private String EldHouseName;
    private String Address;
    private String PhoneNumber;
    private String Lat;
    private String Long;
    private int AvailableBeds;
    private double Rating;
    private int StarRating;
    private int is1;
    private int is2;
    private int is3;
    private int is4;
    private int is5;
    private int is6;
    private int zone;
    private int AgeRange;

    public elderlyHouse() {
    }

    @Override
    public String toString() {
        return "elderlyHouse{" +
                "EldHouseName='" + EldHouseName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Lat='" + Lat + '\'' +
                ", Long='" + Long + '\'' +
                ", AvailableBeds=" + AvailableBeds +
                ", Rating=" + Rating +
                ", StarRating=" + StarRating +
                ", is1=" + is1 +
                ", is2=" + is2 +
                ", is3=" + is3 +
                ", is4=" + is4 +
                ", is5=" + is5 +
                ", is6=" + is6 +
                ", zone=" + zone +
                ", AgeRange=" + AgeRange +
                '}';
    }

    public String getEldHouseName() {
        return EldHouseName;
    }

    public void setEldHouseName(String eldHouseName) {
        EldHouseName = eldHouseName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLong() {
        return Long;
    }

    public void setLong(String aLong) {
        Long = aLong;
    }

    public int getAvailableBeds() {
        return AvailableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        AvailableBeds = availableBeds;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public int getStarRating() {
        return StarRating;
    }

    public void setStarRating(int starRating) {
        StarRating = starRating;
    }

    public int getIs1() {
        return is1;
    }

    public void setIs1(int is1) {
        this.is1 = is1;
    }

    public int getIs2() {
        return is2;
    }

    public void setIs2(int is2) {
        this.is2 = is2;
    }

    public int getIs3() {
        return is3;
    }

    public void setIs3(int is3) {
        this.is3 = is3;
    }

    public int getIs4() {
        return is4;
    }

    public void setIs4(int is4) {
        this.is4 = is4;
    }

    public int getIs5() {
        return is5;
    }

    public void setIs5(int is5) {
        this.is5 = is5;
    }

    public int getIs6() {
        return is6;
    }

    public void setIs6(int is6) {
        this.is6 = is6;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public int getAgeRange() {
        return AgeRange;
    }

    public void setAgeRange(int ageRange) {
        AgeRange = ageRange;
    }

    public elderlyHouse(String eldHouseName, String address, String phoneNumber, String lat, String aLong, int availableBeds, double rating, int starRating, int is1, int is2, int is3, int is4, int is5, int is6, int zone, int ageRange) {
        EldHouseName = eldHouseName;
        Address = address;
        PhoneNumber = phoneNumber;
        Lat = lat;
        Long = aLong;
        AvailableBeds = availableBeds;
        Rating = rating;
        StarRating = starRating;
        this.is1 = is1;
        this.is2 = is2;
        this.is3 = is3;
        this.is4 = is4;
        this.is5 = is5;
        this.is6 = is6;
        this.zone = zone;
        AgeRange = ageRange;
    }
}
