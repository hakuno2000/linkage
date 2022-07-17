package com.bglobal.linkage.service;

import com.bglobal.linkage.entity.ShopMapping;
import com.bglobal.linkage.repo.ShopMappingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopMappingServiceImpl implements ShopMappingService{
    @Autowired
    private ShopMappingRepo shopMappingRepo;

    @Override
    public Integer getShopIdByShopCode(String shopCode) {
        ShopMapping shop = shopMappingRepo.findFirstByCommonCode(shopCode);
        if (shop == null) return null;
        return shop.getShopId();
    }

    @Override
    public String getShopCodeByShopId(Integer shopId) {
        ShopMapping shop = shopMappingRepo.findFirstByShopId(shopId);
        if (shop == null) return null;
        return shop.getCommonCode();
    }
}
