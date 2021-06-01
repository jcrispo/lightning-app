package com.dtn.app.dao;

import com.dtn.app.utility.FileUtility;
import com.dtn.app.utility.JsonUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssetsDao implements IBasicDao {
    private static List<Map<String, Object>> assets = new ArrayList<>();

    public AssetsDao(String fileName) {
        FileUtility fileUtil = new FileUtility(fileName);
        String jsonString = fileUtil.getFileAsJsonString();
        assets = JsonUtility.fromJsonToListOfMap(jsonString);
    }

    public void setValue(List<Map<String, Object>> assetsParam) {
        assets = assetsParam;
    }

    @Override
    public List<Map<String, Object>> getValue() {
        return assets;
    }
}
