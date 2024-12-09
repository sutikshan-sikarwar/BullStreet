package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.models.Asset;
import com.sutikshan.bullstreet.models.Coin;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.repositories.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImplementation implements AssetService{

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Asset createAsset(User user, Coin coin, double quantity) {
        Asset asset = new Asset();
        asset.setUser(user);
        asset.setCoin(coin);
        asset.setQuantity(quantity);
        asset.setBuyPrice(coin.getCurrentPrice());
        return assetRepository.save(asset);
    }

    @Override
    public Asset getAssetById(String assetId) throws Exception {
        return assetRepository.findById(assetId).orElseThrow(()->new Exception("asset not found!"));
    }

    @Override
    public Asset getAssetByUserIdAndId(String userId, String assetId) {
        return null;
    }

    @Override
    public List<Asset> getUserAssets(String userId) {
        return assetRepository.findByUserId(userId);
    }

    @Override
    public Asset updateAsset(String assetId, double quantity) throws Exception {

        Asset oldAsset = getAssetById(assetId);
        oldAsset.setQuantity(quantity+ oldAsset.getQuantity());
        return assetRepository.save(oldAsset);
    }

    @Override
    public Asset findAssetByUserIdAndCoinId(String userId, String coinId) {
        return assetRepository.findByUserIdAndCoinId(userId,coinId);
    }

    @Override
    public void deleteAsset(String assetId) {
        assetRepository.deleteById(assetId);
    }
}
