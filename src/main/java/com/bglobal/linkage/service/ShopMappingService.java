package com.bglobal.linkage.service;

public interface ShopMappingService {
    Integer getShopIdByShopCode(String shopCode);
    String getShopCodeByShopId(Integer shopId);
}
