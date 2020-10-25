package com.wongweiye.service;

import org.springframework.stereotype.Service;


import com.wongweiye.dto.SystemParameterIntDTO;

@Service
public interface OnBoardStatusService {

    public SystemParameterIntDTO findOnBoardStatus(String parGroup, String parName);

}
