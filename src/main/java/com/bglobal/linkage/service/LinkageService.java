package com.bglobal.linkage.service;

import com.bglobal.linkage.DTO.LinkageResponseCategoryDTO;
import com.bglobal.linkage.DTO.MPOSAuthorizeDTO;
import com.bglobal.linkage.DTO.MPOSLoginDTO;

import java.util.List;

public interface LinkageService {
    MPOSLoginDTO loginToMPOS();
    MPOSAuthorizeDTO authorizeMPOS();
    List<LinkageResponseCategoryDTO> findCategoriesByCommonCode(String categoryCode, String accessToken);
}
