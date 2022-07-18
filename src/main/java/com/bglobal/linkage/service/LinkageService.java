package com.bglobal.linkage.service;

import com.bglobal.linkage.DTO.*;
import com.bglobal.linkage.table.TableActivityDTO;

import java.util.List;

public interface LinkageService {
    MPOSLoginDTO loginToMPOS();
    MPOSAuthorizeDTO authorizeMPOS();
    Integer getShopIdByShopCode(String shopCode);
    List<LinkageRequestCategoryDTO> findCategoriesByCommonCode(String shopCode, Integer serviceId, String categoryCode);
    List<LinkageRequestItemDTO> findItemsByCommonCode(String shopCode, Integer serviceId, String itemCode);

    List<LinkageRequestItemDetailDTO> findItemDetailsByCommonCode(String shopCode, Integer serviceId, String itemDetailCode);

    List<LinkageRequestItemDetailContentDTO> findItemDetailContentsByCommonCode(String shopCode, Integer serviceId, String itemDetailCode, String itemDetailContentCode);
    List<LinkageRequestTableDTO> findTablesByCommonCode(String shopCode, Integer serviceId, String tableCode);
    List<TableActivityDTO> findTableActivitiesByCommonCode(String shopCode, Integer serviceId, String tableActivityCode, String tableCode, String ownerId);
}
