package com.bglobal.linkage.controller;

import com.bglobal.linkage.DTO.LinkageRequestCategoryDTO;
import com.bglobal.linkage.DTO.LinkageResponseCategoryDTO;
import com.bglobal.linkage.service.LinkageService;
import com.bglobal.linkage.support.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    private LinkageService linkageService;

    @GetMapping("/category/read")
    public ResponseEntity<List<LinkageResponseCategoryDTO>> getCategories(@RequestHeader("authorization") String token, HttpServletRequest request) {
        if (!Authorization.checkToken(token, request)) {
            return ResponseEntity.status(401).build();
        }

        List<LinkageRequestCategoryDTO> tempCategories = linkageService.findCategoriesByCommonCode("");
        if (tempCategories.isEmpty()) return ResponseEntity.noContent().build();

        List<LinkageResponseCategoryDTO> categories = new ArrayList<>();
        for (LinkageRequestCategoryDTO tempCategory : tempCategories) {
            LinkageResponseCategoryDTO category = new LinkageResponseCategoryDTO(tempCategory);
            categories.add(category);
        }

        return ResponseEntity.ok(categories);
    }
}
