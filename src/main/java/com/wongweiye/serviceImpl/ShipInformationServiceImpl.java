package com.wongweiye.serviceImpl;

import com.wongweiye.dto.ShipInformationDTO;
import com.wongweiye.model.ShipInformation;
import com.wongweiye.repository.ShipInformationRepository;
import com.wongweiye.service.ShipInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipInformationServiceImpl implements ShipInformationService {

    @Autowired
    private ShipInformationRepository shipInformationRepository;

    public List<ShipInformationDTO> getShipInformation() {

        List<ShipInformation> shipInfo = getShipInformationRepository().findAll();

        if(!shipInfo.isEmpty())
        {
            return shipInfo.stream().limit(1).map( s -> new ShipInformationDTO(s.getShipID(),s.getShipReferenceID(),
                    s.getShipRecordID(),s.isShipEnabled(),s.getShipCode(),s.getShipName(),s.getShipType()))
                    .collect(Collectors.toList());

        }
        else
        {
            return null;
        }
    }

    public ShipInformationRepository getShipInformationRepository() {
        return shipInformationRepository;
    }

    public void setShipInformationRepository(ShipInformationRepository shipInformationRepository) {
        this.shipInformationRepository = shipInformationRepository;
    }
}
