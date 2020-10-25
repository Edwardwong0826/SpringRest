package com.wongweiye.service;


import com.wongweiye.dto.ShipInformationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipInformationService {
    public List<ShipInformationDTO> getShipInformation();

}
