package com.dtn.app.service;

import com.dtn.app.constants.AppConstants;
import com.dtn.app.dao.AssetsDao;
import com.dtn.app.model.Asset;
import com.dtn.app.model.LightningStrike;
import com.dtn.app.utility.FileUtility;
import com.dtn.app.utility.JsonUtility;
import org.geotools.tile.impl.bing.BingTileUtil;

import java.util.Map;

import static com.dtn.app.constants.AppConstants.LIGHTNING_ALERT;
import static com.dtn.app.constants.AppConstants.LIGHTNING_NO_HIT;

public class LightningService {
    private AssetsDao assetsDao;
    private UserInputService userInputService;

    public LightningService(AssetsDao assetsDao) {
        this.assetsDao = assetsDao;
        this.userInputService = new UserInputService();
    }

    public void handleLightningData() {
        LightningStrike lightning = userInputService.getValidLightningData("Enter a lightning strike data: ");
        Map<String, Asset> assetsMap = assetsDao.getAssetsMap();
        String lightningQuadKey = BingTileUtil.lonLatToQuadKey(lightning.getLongitude(), lightning.getLatitude(), AppConstants.ZOOM_LEVEL);
        Asset assetHit = assetsMap.get(lightningQuadKey);
        if (assetHit != null) {
            System.out.println(String.format(LIGHTNING_ALERT, assetHit.getAssetOwner().toString(), assetHit.getAssetName()));
        } else {
            System.out.println(LIGHTNING_NO_HIT);
        }

        //Testing
        /*
        FileUtility lightningFile = new FileUtility("/lightning-sample.json");
        List<Map<String, Object>> lightningList = JsonUtility.fromJsonToListOfMap(lightningFile.getFileAsJsonString());
        for (Map<String, Object> lightningMap : lightningList) {
            LightningStrike lightningStrike = new LightningStrike(lightningMap);
            String quadKey = BingTileUtil.lonLatToQuadKey(lightningStrike.getLongitude(), lightningStrike.getLatitude(), AppConstants.ZOOM_LEVEL);
            System.out.println("quadKey Value: " + quadKey);
            Asset asset = assetsMap.get(quadKey);
            if (asset != null) {
                System.out.println("Lightning: " + lightningStrike.toString());
                System.out.println("Asset: " + asset.toString());
            } else {
                System.out.println("Lightning did not hit any asset.");
            }
        }
         */

    }
}

