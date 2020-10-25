package com.wongweiye.serviceImpl;

import com.wongweiye.dto.ConfigurationLocationDTO;
import com.wongweiye.repository.ConfigurationLocationRepository;
import com.wongweiye.service.ConfigurationLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationLocationServiceImpl implements ConfigurationLocationService {

    @Autowired
    private ConfigurationLocationRepository configurationLocationRepository;

    @Override
    public Page<ConfigurationLocationDTO> getCreditCardLocation(String status, int offset, int limit) {

        Page<ConfigurationLocationDTO> locationResult;
        Pageable pageable = PageRequest.of(offset, limit);
        locationResult = configurationLocationRepository.getLoctaion(status,pageable);

        return locationResult;
    }

}
