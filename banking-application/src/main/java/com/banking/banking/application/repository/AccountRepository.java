package com.banking.banking.application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.banking.application.entity.Account;
public interface AccountRepository extends JpaRepository<Account,Long>{

}
