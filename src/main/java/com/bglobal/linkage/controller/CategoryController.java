package com.bglobal.linkage.controller;

import com.bglobal.linkage.DTO.LinkageRequestCategoryDTO;
import com.bglobal.linkage.DTO.LinkageResponseCategoryDTO;
import com.bglobal.linkage.DTO.ListCategoryDTO;
import com.bglobal.linkage.service.LinkageService;
import com.bglobal.linkage.support.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    private LinkageService linkageService;

    @GetMapping("/category/read")
    public ResponseEntity<ListCategoryDTO> getCategories(@RequestHeader("authorization") String token,
                                                         @RequestParam(name = "categoryCode", required = false, defaultValue = "") String categoryCode,
                                                         @RequestParam(name = "shopCode", required = false, defaultValue = "277_404") String shopCode,
                                                         @RequestParam(name = "categoryState", required = false, defaultValue = "1") Integer categoryState,
                                                         HttpServletRequest request) {
        if (!Authorization.checkToken(token, request)) {
            return ResponseEntity.status(401).build();
        }

        List<LinkageRequestCategoryDTO> tempCategories = linkageService.findCategoriesByCommonCode(shopCode, 2, categoryCode);
        if (tempCategories.isEmpty()) return ResponseEntity.noContent().build();

        List<LinkageResponseCategoryDTO> categories = new ArrayList<>();
        for (LinkageRequestCategoryDTO tempCategory : tempCategories) {
            if (!tempCategory.getState().equals(categoryState)) continue;
            LinkageResponseCategoryDTO category = new LinkageResponseCategoryDTO(tempCategory);
            categories.add(category);
        }

        ListCategoryDTO listCategoryDTO = new ListCategoryDTO();
        listCategoryDTO.setCategories(categories);
        listCategoryDTO.setShopCode(shopCode);

        return ResponseEntity.ok(listCategoryDTO);
    }
}
