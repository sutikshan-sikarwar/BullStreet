package com.sutikshan.bullstreet.controllers;

import com.sutikshan.bullstreet.models.Asset;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.services.AssetService;
import com.sutikshan.bullstreet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asset")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @Autowired
    private UserService userService;

    @GetMapping("/{assetId}")
    public ResponseEntity<Asset> getAssetById(@PathVariable String assetId) throws Exception {
        Asset asset = assetService.getAssetById(assetId);
        return ResponseEntity.ok().body(asset);
    }

    @GetMapping("/coin/{coinId}/user")
    public ResponseEntity<Asset> getAssetByUserIdAndCoinId(
            @PathVariable String coinId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);
        Asset asset = assetService.findAssetByUserIdAndCoinId(user.getId(), coinId);
        return ResponseEntity.ok().body(asset);
    }

    public ResponseEntity<List<Asset>> getAssetsForUser(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);
        List<Asset> assets = assetService.getUserAssets(user.getId());
        return ResponseEntity.ok().body(assets);
    }
}
