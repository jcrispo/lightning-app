package com.dtn.app.dao;

import com.dtn.app.model.Asset;
import com.dtn.app.utility.FileUtility;
import com.dtn.app.utility.JsonUtility;

import java.util.*;

public class AssetsDao implements IBasicDao {
    private List<Map<String, Object>> assets = new ArrayList<>();
    private Map<String, Asset> assetsMap = new HashMap<>();
    private Set<String> assetQuadKeyHits = new HashSet<>();

    public AssetsDao(String fileName) {
        FileUtility fileUtil = new FileUtility(fileName);
        String jsonString = fileUtil.getFileAsJsonString();
        assets = JsonUtility.fromJsonToListOfMap(jsonString);
        assetsMap = convertToMapOfAssets(assets);
    }

    public Map<String, Asset> getAssetsMap() {
        return assetsMap;
    }

    public void setValue(List<Map<String, Object>> assetsParam) {
        assets = assetsParam;
    }

    @Override
    public List<Map<String, Object>> getValue() {
        return assets;
    }

    public void addToQuadKeysHit(String quadKey) {
        assetQuadKeyHits.add(quadKey);
    }

    public Set<String> getAssetQuadKeyHits() {
        return assetQuadKeyHits;
    }

    /*
     * Returns a Map of Asset object
     * Map Key is the Asset Quad Key = Asset.getQuadKey()
     */
    private Map<String, Asset> convertToMapOfAssets(List<Map<String, Object>> assetsListMap) {
        Map<String, Asset> returnValue = new HashMap<>();

        for (Map<String, Object> assetMap : assetsListMap) {
            Asset asset = new Asset(assetMap);
            returnValue.put(asset.getQuadKey(), asset);
        }

        return returnValue;
    }
}
