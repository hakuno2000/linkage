package com.bglobal.linkage.service;

import com.bglobal.linkage.DTO.*;

import java.util.List;

public interface LinkageService {
    MPOSLoginDTO loginToMPOS();
    MPOSAuthorizeDTO authorizeMPOS();
    List<LinkageRequestCategoryDTO> findCategoriesByCommonCode(String shopCode, Integer serviceId, String categoryCode);
    List<LinkageRequestItemDTO> findItemsByCommonCode(String shopCode, Integer serviceId, String itemCode);

    List<LinkageRequestItemDetailDTO> findItemDetailsByCommonCode(String shopCode, Integer serviceId, String itemDetailCode);

    List<LinkageRequestItemDetailContentDTO> findItemDetailContentsByCommonCode(String shopCode, Integer serviceId, String itemDetailCode, String itemDetailContentCode);
}
