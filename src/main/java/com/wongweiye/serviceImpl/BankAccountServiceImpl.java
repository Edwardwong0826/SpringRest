package com.wongweiye.serviceImpl;

import com.wongweiye.model.Account;
import com.wongweiye.model.SystemParameter;
import com.wongweiye.repository.AccountRepository;
import com.wongweiye.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public int getAccountAmount(int id) {

        Optional<Account> account = accountRepository.findByID(id);

            Account a = account.get();

            if(a.getAmount() > 0)
            {
                return a.getAmount();
            }

            return 0;

    }
}
