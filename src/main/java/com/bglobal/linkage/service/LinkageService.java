package com.bglobal.linkage.service;

import com.bglobal.linkage.DTO.LinkageRequestCategoryDTO;
import com.bglobal.linkage.DTO.MPOSAuthorizeDTO;
import com.bglobal.linkage.DTO.MPOSLoginDTO;

import java.util.List;

public interface LinkageService {
    MPOSLoginDTO loginToMPOS();
    MPOSAuthorizeDTO authorizeMPOS();
    List<LinkageRequestCategoryDTO> findCategoriesByCommonCode(String categoryCode);
}
