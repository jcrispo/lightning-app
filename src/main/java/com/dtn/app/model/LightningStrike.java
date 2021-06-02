package com.dtn.app.model;

import com.dtn.app.utility.MapUtility;

import java.util.Map;

public class LightningStrike {
    private Integer flashType;
    private Long strikeTime;
    private Double latitude;
    private Double longitude;
    private Float peakAmps;
    private String reserved;
    private Float icHeight;
    private Long receivedTime;
    private Integer numberOfSensors;
    private Integer multiplicity;

    @Override
    public String toString() {
        return "LightningStrike{" +
                "flashType=" + flashType +
                ", strikeTime=" + strikeTime +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", peakAmps=" + peakAmps +
                ", reserved='" + reserved + '\'' +
                ", icHeight=" + icHeight +
                ", receivedTime=" + receivedTime +
                ", numberOfSensors=" + numberOfSensors +
                ", multiplicity=" + multiplicity +
                '}';
    }

    public LightningStrike(Map<String, Object> data) {
        flashType = MapUtility.getMapIntegerValue(data, "flashType");
        strikeTime = MapUtility.getMapLongValue(data, "strikeTime");
        latitude = MapUtility.getMapDoubleValue(data, "latitude");
        longitude = MapUtility.getMapDoubleValue(data, "longitude");
        peakAmps = MapUtility.getMapFloatValue(data, "peakAmps");
        reserved = MapUtility.getMapStringValue(data, "reserved");
        icHeight = MapUtility.getMapFloatValue(data, "icHeight");
        receivedTime = MapUtility.getMapLongValue(data, "receivedTime");
        numberOfSensors = MapUtility.getMapIntegerValue(data, "numberOfSensors");
        multiplicity = MapUtility.getMapIntegerValue(data, "multiplicity");
    }

    public Integer getFlashType() {
        return flashType;
    }

    public void setFlashType(Integer flashType) {
        this.flashType = flashType;
    }

    public Long getStrikeTime() {
        return strikeTime;
    }

    public void setStrikeTime(Long strikeTime) {
        this.strikeTime = strikeTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Float getPeakAmps() {
        return peakAmps;
    }

    public void setPeakAmps(Float peakAmps) {
        this.peakAmps = peakAmps;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public Float getIcHeight() {
        return icHeight;
    }

    public void setIcHeight(Float icHeight) {
        this.icHeight = icHeight;
    }

    public Long getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Long receivedTime) {
        this.receivedTime = receivedTime;
    }

    public Integer getNumberOfSensors() {
        return numberOfSensors;
    }

    public void setNumberOfSensors(Integer numberOfSensors) {
        this.numberOfSensors = numberOfSensors;
    }

    public Integer getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(Integer multiplicity) {
        this.multiplicity = multiplicity;
    }
}
