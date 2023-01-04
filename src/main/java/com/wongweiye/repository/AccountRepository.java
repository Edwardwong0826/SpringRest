package com.wongweiye.repository;

import com.wongweiye.dto.AccountDTO;
import com.wongweiye.model.Account;
import com.wongweiye.model.SystemParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

//    Optional<Account> findByID(Integer id);

}
