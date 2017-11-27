package lld.wru.model;

import java.time.LocalDateTime;

public class LocationQueryResult {
    private String myPhoneNum;
    private String frientPhoneNum;
    private LocalDateTime lastRecordTime;
    private double latitude;
    private double longitude;
    private String errorMessage;

    public String getMyPhoneNum() {
        return myPhoneNum;
    }

    public void setMyPhoneNum(String myPhoneNum) {
        this.myPhoneNum = myPhoneNum;
    }

    public String getFrientPhoneNum() {
        return frientPhoneNum;
    }

    public void setFrientPhoneNum(String frientPhoneNum) {
        this.frientPhoneNum = frientPhoneNum;
    }

    public LocalDateTime getLastRecordTime() {
        return lastRecordTime;
    }

    public void setLastRecordTime(LocalDateTime lastRecordTime) {
        this.lastRecordTime = lastRecordTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "LocationQueryResult [myPhoneNum=" + myPhoneNum + ", frientPhoneNum=" + frientPhoneNum
                + ", lastRecordTime=" + lastRecordTime + ", latitude=" + latitude + ", longitude=" + longitude
                + ", errorMessage=" + errorMessage + "]";
    }
}
