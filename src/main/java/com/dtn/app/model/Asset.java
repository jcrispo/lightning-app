package com.dtn.app.model;

import com.dtn.app.utility.MapUtility;

import java.util.Map;

public class Asset {
    private String assetName;
    private String quadKey;
    private Long assetOwner;

    public Asset(Map<String, Object> assetMap) {
        assetName = MapUtility.getMapStringValue(assetMap, "assetName");
        quadKey = MapUtility.getMapStringValue(assetMap, "quadKey");
        assetOwner = MapUtility.getMapLongValue(assetMap, "assetOwner");
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getQuadKey() {
        return quadKey;
    }

    public void setQuadKey(String quadKey) {
        this.quadKey = quadKey;
    }

    public Long getAssetOwner() {
        return assetOwner;
    }

    public void setAssetOwner(Long assetOwner) {
        this.assetOwner = assetOwner;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "assetName='" + assetName + '\'' +
                ", quadKey=" + quadKey +
                ", assetOwner=" + assetOwner +
                '}';
    }
}
