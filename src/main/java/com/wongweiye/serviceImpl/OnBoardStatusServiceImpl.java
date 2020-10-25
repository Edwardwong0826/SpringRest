package com.wongweiye.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wongweiye.dto.SystemParameterIntDTO;
import com.wongweiye.repository.SystemParameterRepository;
import com.wongweiye.service.OnBoardStatusService;

import javax.transaction.Transactional;

@Service
@Transactional
public class OnBoardStatusServiceImpl implements OnBoardStatusService{

    @Autowired
    private SystemParameterRepository systemParameterRepository;

    private enum Status {

        ONBOARD("Onboard after check-in"),
        ASHORE("Ashore after check-in, must swiped card to be onboard"),
        DISPLAY("Display option box");

        private final String label;

        private Status(String label) {
            this.label =label;
        }
    }

    public SystemParameterIntDTO findOnBoardStatus(String parGroup, String parName) {


        SystemParameterIntDTO result = systemParameterRepository.findGroupAndNameIntValue(parGroup,parName);

        if (result != null) {

            result.setDesc(Status.values()[result.getValue()].label);

        }

        return result;

    }

}
