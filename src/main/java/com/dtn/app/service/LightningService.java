package com.dtn.app.service;

import com.dtn.app.constants.AppConstants;
import com.dtn.app.dao.AssetsDao;
import com.dtn.app.model.Asset;
import com.dtn.app.model.LightningStrike;
import org.geotools.tile.impl.bing.BingTileUtil;

import java.util.Map;

public class LightningService {
    private AssetsDao assetsDao;
    private UserInputService userInputService;

    public LightningService(AssetsDao assetsDao) {
        this.assetsDao = assetsDao;
        this.userInputService = new UserInputService();
    }

    public void handleLightningData(String userInput) {
        //Map<String, Object> lightningDataMap = userInputService.getValidLightningData("Enter a lightning strike data: ");
        LightningStrike lightning = userInputService.getValidLightningData("Enter a lightning strike data: ");
        Map<String, Asset> assetsMap = assetsDao.getAssetsMap();
        System.out.println("FlashType: " + lightning.getFlashType());
        System.out.println("User has provided data: " + lightning.toString());

        String quadKey = BingTileUtil.lonLatToQuadKey(lightning.getLongitude(), lightning.getLatitude(), AppConstants.ZOOM_LEVEL);
        System.out.println("quadKey Value: " + quadKey);

        //Testing
        Asset asset = assetsMap.get(quadKey);
        if (asset != null) {
            System.out.println("Asset: " + asset.toString());
        } else {
            System.out.println("Lightning did not hit any asset.");
        }

    }
}

