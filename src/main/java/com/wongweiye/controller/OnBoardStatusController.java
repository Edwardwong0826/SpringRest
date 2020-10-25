package com.wongweiye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wongweiye.constant.ParameterConstant;
import com.wongweiye.dto.SystemParameterIntDTO;
import com.wongweiye.service.OnBoardStatusService;


@RequestMapping(path = "/v1/configurations", produces = "application/json")
@RestController
public class OnBoardStatusController {

    @Autowired
    private OnBoardStatusService onBoardStatusSerivce;

    @GetMapping("/onboardStatusAfterCheckIn")
    public ResponseEntity<SystemParameterIntDTO> getOnBoardStatus() {

        SystemParameterIntDTO result= onBoardStatusSerivce.findOnBoardStatus(ParameterConstant.PAR_GENERAL,ParameterConstant.PAR_CHECK_IN_STATUS);

        if(result != null) {
            return ResponseEntity.ok().body(result);
        }
        else
        {
            return ResponseEntity.notFound().build();

        }

    }




}
