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
    private boolean is1;
    private boolean is2;
    private boolean is3;
    private boolean is4;
    private boolean is5;
    private boolean is6;
    private int zone;
    private int AgeRange;

    public elderlyHouse() {
        EldHouseName = "";
        Address = "";
        PhoneNumber = "phoneNumber";
        Lat = "lat";
        Long = "aLong";
        AvailableBeds = 0;
        Rating = 0.0;
        StarRating = 0;
        this.is1 = false;
        this.is2 = false;
        this.is3 = false;
        this.is4 = false;
        this.is5 = false;
        this.is6 = false;
        this.zone = 0;
        AgeRange = 0;


    }

    @Override
    public String toString() {
        return "sdasd";
    }


    public elderlyHouse(String eldHouseName, String address, String phoneNumber, String lat, String aLong, int availableBeds, double rating, int starRating, boolean is1, boolean is2, boolean is3, boolean is4, boolean is5, boolean is6, int zone, int ageRange) {
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

    public boolean isIs1() {
        return is1;
    }

    public void setIs1(boolean is1) {
        this.is1 = is1;
    }

    public boolean isIs2() {
        return is2;
    }

    public void setIs2(boolean is2) {
        this.is2 = is2;
    }

    public boolean isIs3() {
        return is3;
    }

    public void setIs3(boolean is3) {
        this.is3 = is3;
    }

    public boolean isIs4() {
        return is4;
    }

    public void setIs4(boolean is4) {
        this.is4 = is4;
    }

    public boolean isIs5() {
        return is5;
    }

    public void setIs5(boolean is5) {
        this.is5 = is5;
    }

    public boolean isIs6() {
        return is6;
    }

    public void setIs6(boolean is6) {
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



}
