package com.wongweiye.controller;

import com.wongweiye.dto.ShipInformationDTO;
import com.wongweiye.service.ShipInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/v2", produces = "application/json")
@RestController
@SuppressWarnings("unchecked")
public class ShipInformationController {

    @Autowired
    ShipInformationService shipInformationService;


    @GetMapping("/userDetails/me/shipProperties")
    public ResponseEntity<ShipInformationDTO> getShipID(){


        List<ShipInformationDTO> shipInfo = shipInformationService.getShipInformation();

        if(shipInfo != null)
        {
            return ResponseEntity.ok().body(shipInfo.get(0));

        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
}
