package com.dtn.app.dao;

import com.dtn.app.model.Asset;
import com.dtn.app.utility.FileUtility;
import com.dtn.app.utility.JsonUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AssetsDao implements IBasicDao {
    private static List<Map<String, Object>> assets = new ArrayList<>();
    private static Map<String, Asset> assetsMap = new HashMap<>();

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

    /*
     * Returns a Map of Asset object
     * Map Key is the Asset Quad Key = Asset.getQuadKey()
     */
    private Map<String, Asset> convertToMapOfAssets(List<Map<String, Object>> assetsListMap) {
        Map<String, Asset> assetsMap = new HashMap<>();

        for (Map<String, Object> assetMap : assetsListMap) {
            Asset asset = new Asset(assetMap);
            assetsMap.put(asset.getQuadKey(), asset);
        }

        return assetsMap;
    }
}
