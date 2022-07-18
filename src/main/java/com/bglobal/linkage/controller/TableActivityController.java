package com.bglobal.linkage.controller;

import com.bglobal.linkage.table.TableActivityDTO;
import com.bglobal.linkage.service.LinkageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
public class TableActivityController {
    @Autowired
    private LinkageService linkageService;

    @GetMapping("/table/activity")
    public ResponseEntity<List<TableActivityDTO>> getTableActivity(@RequestHeader("authorization") String token,
                                                                   @RequestParam(name = "shopCode", required = false, defaultValue = "277_404") String shopCode,
                                                                   @RequestParam(name = "tableActivityCode", required = false, defaultValue = "") String tableActivityCode,
                                                                   @RequestParam(name = "tableCode", required = false, defaultValue = "") String tableCode,
                                                                   HttpServletRequest request) {
//        if (!Authorization.checkToken(token, request)) {
//            return ResponseEntity.status(401).build();
//        }
        List<TableActivityDTO> tableActivityDTOList = linkageService.findTableActivitiesByCommonCode(shopCode, 2, tableActivityCode, tableCode, "277");
        if (tableActivityDTOList == null) return ResponseEntity.status(404).build();
        return ResponseEntity.ok(tableActivityDTOList);
    }
}
