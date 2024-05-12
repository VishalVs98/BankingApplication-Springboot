package com.banking.banking.application.serviceImpl;
import org.springframework.stereotype.Service;

import com.banking.banking.application.Mapper.AccountMapper;
import com.banking.banking.application.dto.Accountdto;
import com.banking.banking.application.entity.Account;
import com.banking.banking.application.repository.AccountRepository;
import com.banking.banking.application.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{  
	private AccountRepository accountRepository;	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	@Override
	public Accountdto createAccount(Accountdto accountdto) {
		// TODO Auto-generated method stub
		Account  acc=AccountMapper.mapToAccount(accountdto);
		accountRepository.save(acc);
		return AccountMapper.mapToAccountdto(acc);
	}
	@Override
	public Accountdto getAccountById(Long id) {
		Account account = accountRepository.findById(id)
				       .orElseThrow(()->new RuntimeException("Account does not exists"));
				         return AccountMapper.mapToAccountdto(account);
	}
	@Override
	public Accountdto deposit(Long id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id)
			       .orElseThrow(()->new RuntimeException("Account does not exists"));
		
		double total=account.getBalance()+amount;
		account.setBalance(total);
		Account saveAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountdto(saveAccount);
	}
	@Override
	public Accountdto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id)
			       .orElseThrow(()->new RuntimeException("Account does not exists"));
		
		if(account.getBalance()<amount) {
			throw new RuntimeException("InsufficientBalance");
		}
		
		double total=account.getBalance()-amount;
		account.setBalance(total);
		Account saveAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountdto(saveAccount);
		
	}

}
