package com.wongweiye.repositoryImpl;

import com.wongweiye.dto.ConfigurationLocationDTO;
import com.wongweiye.model.ConfigurationLocation;
import com.wongweiye.repository.ConfigurationLocationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigurationLocationRepositoryImpl extends ExtendedRepositoryImpl<ConfigurationLocation, Long> implements ConfigurationLocationRepository {


    public ConfigurationLocationRepositoryImpl(EntityManager entityManager) {
        super(ConfigurationLocation.class, entityManager);
    }

    @Override
    public Page<ConfigurationLocationDTO> getLoctaion(String status, Pageable pageable) {

        StringBuilder sql = new StringBuilder("select LOC_ID,LOC_ART,LOC_TITLE,LOC_DESCR,LOC_DECK,LOC_FILENAME,LOC_STATUS,LOC_OVERLAP,LOC_COMMENT\r\n" +
                ",typ_dek.typ_comment\r\n" +
                "from LOC JOIN TYP_DEK ON LOC.LOC_DECK = TYP_DEK.TYP_ART");

        Query query = super.createQuery(sql.toString());
        query.setFirstResult((int)pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        @SuppressWarnings("unchecked")
        List<Object> object = query.getResultList();
        int totalSize = query.getResultList().size();

        List<ConfigurationLocationDTO> locationDTO = null;


        locationDTO = object.stream().map( o -> (Object[])o).map(o -> new ConfigurationLocationDTO( (Number)o[0], (String)o[1], (String)o[2],
                (String)o[3], (String)o[4], (String)o[5], ((Number) o[6]).toString().equals("1"), ((Number) o[6]).toString().equals("1"), (String)o[8], (String)o[9]
        )).collect(Collectors.toList());

        boolean checkStatus;
        checkStatus = status.equals("true") ? true : false;

        locationDTO = locationDTO.stream().filter(l -> checkStatus ? l.isStatus() == true : l.isStatus() == false)
                .collect(Collectors.toList());

        return new PageImpl<>(locationDTO, pageable, (long)totalSize);
    }
}
