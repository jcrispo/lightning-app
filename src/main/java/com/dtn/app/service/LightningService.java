package com.dtn.app.service;

import com.dtn.app.constants.AppConstants;
import com.dtn.app.dao.AssetsDao;
import com.dtn.app.model.Asset;
import com.dtn.app.model.LightningStrike;
import org.geotools.tile.impl.bing.BingTileUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.dtn.app.constants.AppConstants.*;

public class LightningService {
    private AssetsDao assetsDao;
    private UserInputService userInputService;

    public LightningService(AssetsDao assetsDao) {
        this.assetsDao = assetsDao;
        this.userInputService = new UserInputService();
    }

    public void handleLightningData() {
        List<LightningStrike> lightningList = userInputService.getValidLightningData(MENU_INPUT_DATA_CHOICE);
        Map<String, Asset> assetsMap = assetsDao.getAssetsMap();

        for (LightningStrike lightning : lightningList) {
            checkLightningHitsOnAssets(assetsMap, lightning);
        }
    }

    private void checkLightningHitsOnAssets(Map<String, Asset> assetsMap, LightningStrike lightning) {
        String lightningQuadKey = BingTileUtil.lonLatToQuadKey(lightning.getLongitude(), lightning.getLatitude(), AppConstants.ZOOM_LEVEL);
        Set<String> assetsAlreadyHit = this.assetsDao.getAssetQuadKeyHits();

        if (assetsAlreadyHit.contains(lightningQuadKey) || lightning.getFlashType().intValue() != FLASHTYPE_GROUND) return;

        Asset assetHit = assetsMap.get(lightningQuadKey);
        if (assetHit != null) {
            System.out.println(String.format(LIGHTNING_ALERT, assetHit.getAssetOwner().toString(), assetHit.getAssetName()));
            this.assetsDao.addToQuadKeysHit(lightningQuadKey);
        }
    }
}

