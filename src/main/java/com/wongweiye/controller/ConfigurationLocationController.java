package com.wongweiye.controller;


import com.wongweiye.dto.ConfigurationLocationDTO;
import com.wongweiye.service.ConfigurationLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RequestMapping(path = "/v2/ships/{shipID}", produces = "application/json")
@RestController
@SuppressWarnings("unchecked")
public class ConfigurationLocationController {

    @Autowired
    ConfigurationLocationService configurationLocationService;

    @SuppressWarnings("rawtypes")
    @GetMapping("/configurations/locations")
    public ResponseEntity<Page<ConfigurationLocationDTO>> getCreditCardLocation(@PathVariable String shipID, @RequestParam("status") String status, @RequestParam("offset") int offset, @RequestParam("limit") int limit) {

        Page<ConfigurationLocationDTO> locationResult = configurationLocationService.getCreditCardLocation(status, offset, limit);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("Count", locationResult.getNumberOfElements());
        result.put("HasMore", locationResult.hasNext());
        result.put("Items", locationResult.getContent());

        if (!locationResult.isEmpty()) {
            return ResponseEntity.ok().body(locationResult);
        } else {
            return ResponseEntity.notFound().build();

        }

    }

}
