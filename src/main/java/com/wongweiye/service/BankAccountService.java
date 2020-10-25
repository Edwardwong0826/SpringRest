package com.wongweiye.service;

import com.wongweiye.model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BankAccountService {

    public int getAccountAmount(int id);

}
