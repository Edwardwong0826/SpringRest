package com.wongweiye.service;

import com.wongweiye.dto.ConfigurationLocationDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ConfigurationLocationService {
    Page<ConfigurationLocationDTO> getCreditCardLocation(String status, int offset, int limit);
}
