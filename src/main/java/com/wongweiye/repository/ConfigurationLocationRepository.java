package com.wongweiye.repository;

import com.wongweiye.dto.ConfigurationLocationDTO;
import com.wongweiye.model.ConfigurationLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConfigurationLocationRepository  extends JpaRepository<ConfigurationLocation, Long> {

    //@Query(value="SELECT location FROM ConfigurationLocation location WHERE (?1 is null or location.locationStatus = ?1) ")
    //public Page<ConfigurationLocationDTO> getLoctaion(Boolean status, Pageable pageable);

    public Page<ConfigurationLocationDTO> getLoctaion(String status,Pageable pageable);

}
