package com.wongweiye.repository;


//import com.hgbu.oracle.ohc.spms.dto.ShipPropertyDetailDTO;
import com.wongweiye.dto.SystemParameterIntDTO;
import com.wongweiye.model.SystemParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface SystemParameterRepository extends JpaRepository<SystemParameter, String> {

    // there are three ways of doing Projections in Spring Data JPA,this repo is doing DTO way
    // Projections means retrieve only specific views / column of the tables
    // 1. scalar value
    // 2. interface
    // 3. DTO

    //@Query("SELECT new com.hgbu.oracle.ohc.spms.dto.ShipPropertyDetailDTO (a.parValue, b.parValue) FROM SystemParameter a, SystemParameter b WHERE a.parName = ?1 AND b.parName = ?2")
    //Optional<ShipPropertyDetailDTO> findParValueByParName(String shipName, String companyName);
    Optional<SystemParameter> findByParName(String name);

    @Query("SELECT new com.wongweiye.dto.SystemParameterIntDTO (cast(a.parValue as int), a.parName as String) FROM SystemParameter a WHERE a.parGroup = ?1 AND a.parName = ?2")
    SystemParameterIntDTO findGroupAndNameIntValue(String parGroup, String parName);

}