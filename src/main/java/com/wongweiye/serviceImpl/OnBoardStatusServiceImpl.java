package com.wongweiye.serviceImpl;

import com.wongweiye.model.SystemParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wongweiye.dto.SystemParameterIntDTO;
import com.wongweiye.repository.SystemParameterRepository;
import com.wongweiye.service.OnBoardStatusService;

import javax.transaction.Transactional;

// https://juejin.cn/post/6844903608224333838 - Spring transaction management详解
// can be enable using @Transactional annotation, or spring provides declarative transaction management by TransactionTemplate or TransactionManager manually manage transaction
// @Transactional not recommended use on interface
// Due to mechanism of Spring AOP, it will create proxy via CGlib, unless target class implement interface then it will use JDK Dynamic proxy
// avoid same class without annotated @Transactional method call @Transactional method, it will make transaction not work, this is because
// Spring AOP proxy causing it, only being called by outside, the spring transaction management will work
// or consider use AspectJ to replace Spring AOP proxy
// annotated method class need to managed by spring, else not work
// the implementation database engine need to support transaction mechanism
@Service
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

    // @Transactional annotation is recommended put on method, and only work on public method
    @Transactional
    public SystemParameterIntDTO findOnBoardStatus(String parGroup, String parName) {


        SystemParameterIntDTO result = systemParameterRepository.findGroupAndNameIntValue(parGroup,parName);
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        Page<SystemParameter> all = systemParameterRepository.findAll(firstPageWithTwoElements);

        if (result != null) {

            result.setDesc(Status.values()[result.getValue()].label);

        }

        return result;

    }

}
