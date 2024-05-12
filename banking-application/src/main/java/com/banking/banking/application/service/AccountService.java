package com.banking.banking.application.service;
import com.banking.banking.application.dto.Accountdto;

public interface AccountService {
 Accountdto createAccount(Accountdto accountdto);
 Accountdto getAccountById(Long id);
 Accountdto deposit(Long id,double amount);
 Accountdto withdraw(Long id,double amount);

}
