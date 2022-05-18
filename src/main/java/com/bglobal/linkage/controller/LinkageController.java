package com.bglobal.linkage.controller;

import com.bglobal.linkage.DTO.LinkageResponseCategoryDTO;
import com.bglobal.linkage.service.LinkageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@CrossOrigin
@RestController
public class LinkageController {
    @Autowired
    private LinkageService linkageService;

    @PostConstruct
    public void postConstruct() {
        linkageService.loginToMPOS();
        linkageService.authorizeMPOS();
    }

    @GetMapping("/linkage/category")
    public ResponseEntity<List<LinkageResponseCategoryDTO>> getCategories() {
        List<LinkageResponseCategoryDTO> categories = linkageService.findCategoriesByCommonCode("");
        if (categories.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(categories);
    }
}
