package com.banking.banking.application.Mapper;

import com.banking.banking.application.dto.Accountdto;
import com.banking.banking.application.entity.Account;

public class AccountMapper {
public static Account mapToAccount(Accountdto accountDto) {
	Account acc=new Account(accountDto.getId(),
			accountDto.getAccountHolderName(),
			accountDto.getBalance()
			);
	return acc;
}
public static Accountdto mapToAccountdto(Account account) {
	Accountdto acc=new Accountdto(account.getAccountId(),
			account.getAccountHolderName(),
			account.getBalance()
			);
	return acc;
}
}
