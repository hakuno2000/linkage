package com.bglobal.linkage.controller;

import com.bglobal.linkage.DTO.*;
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
public class ItemController {
    @Autowired
    private LinkageService linkageService;

    @GetMapping("/item/read")
    public ResponseEntity<ListItemDTO> getItems(@RequestHeader("authorization") String token,
                                                @RequestParam(name = "itemCode", required = false, defaultValue = "") String itemCode,
                                                @RequestParam(name = "shopCode", required = false, defaultValue = "277_404") String shopCode,
                                                @RequestParam(name = "itemState", required = false, defaultValue = "1") Integer itemState,
                                                HttpServletRequest request) {
        if (!Authorization.checkToken(token, request)) {
            return ResponseEntity.status(401).build();
        }

        List<LinkageRequestItemDTO> tempItems = linkageService.findItemsByCommonCode(shopCode, 2, itemCode);
        if (tempItems.isEmpty()) return ResponseEntity.noContent().build();

        List<LinkageResponseItemDTO> items = new ArrayList<>();
        for (LinkageRequestItemDTO tempItem : tempItems) {
            if (!tempItem.getState().equals(itemState)) continue;
            LinkageResponseItemDTO item = new LinkageResponseItemDTO(tempItem);
            items.add(item);
        }

        ListItemDTO listItemDTO = new ListItemDTO();
        listItemDTO.setItems(items);
        listItemDTO.setShopCode(shopCode);

        return ResponseEntity.ok(listItemDTO);
    }
}
