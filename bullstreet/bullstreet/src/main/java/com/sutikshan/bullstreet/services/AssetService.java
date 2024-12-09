package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.models.Asset;
import com.sutikshan.bullstreet.models.Coin;
import com.sutikshan.bullstreet.models.User;

import java.util.List;

public interface AssetService {

    Asset createAsset(User user, Coin coin, double quantity);

    Asset getAssetById(String assetId) throws Exception;

    Asset getAssetByUserIdAndId(String userId, String assetId);

    List<Asset> getUserAssets(String userId);

    Asset updateAsset(String assetId, double quantity) throws Exception;

    Asset findAssetByUserIdAndCoinId(String userId, String coinId);

    void deleteAsset(String assetId);

}
