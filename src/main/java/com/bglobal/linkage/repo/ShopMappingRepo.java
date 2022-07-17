package com.bglobal.linkage.repo;

import com.bglobal.linkage.entity.ShopMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopMappingRepo extends JpaRepository<ShopMapping, Integer> {
    ShopMapping findFirstByCommonCode(String shopCode);
    ShopMapping findFirstByShopId(Integer shopId);
}
