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
public class TableController {
    @Autowired
    private LinkageService linkageService;

    @GetMapping("/table/read")
    public ResponseEntity<ListTableDTO> getTables(@RequestHeader("authorization") String token,
                                                @RequestParam(name = "tableCode", required = false, defaultValue = "") String tableCode,
                                                @RequestParam(name = "shopCode", required = false, defaultValue = "277_404") String shopCode,
                                                @RequestParam(name = "tableState", required = false, defaultValue = "1") Integer tableState,
                                                HttpServletRequest request) {
//        if (!Authorization.checkToken(token, request)) {
//            return ResponseEntity.status(401).build();
//        }

        List<LinkageRequestTableDTO> tempTables = linkageService.findTablesByCommonCode(shopCode, 2, tableCode);
        if (tempTables.isEmpty()) return ResponseEntity.noContent().build();

        List<LinkageResponseTableDTO> tables = new ArrayList<>();
        for (LinkageRequestTableDTO tempTable : tempTables) {
            if (!tempTable.getState().equals(tableState)) continue;
            LinkageResponseTableDTO table = new LinkageResponseTableDTO(tempTable);
            tables.add(table);
        }

        ListTableDTO listTableDTO = new ListTableDTO();
        listTableDTO.setTables(tables);
        listTableDTO.setShopCode(shopCode);

        return ResponseEntity.ok(listTableDTO);
    }
}
