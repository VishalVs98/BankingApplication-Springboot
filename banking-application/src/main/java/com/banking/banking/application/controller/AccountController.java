package com.banking.banking.application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banking.banking.application.dto.Accountdto;
import com.banking.banking.application.service.AccountService;

@RestController
@RequestMapping("/banking/account")
public class AccountController {
	@Autowired
	private  AccountService accountService;
	//add account rest api
	@PostMapping
	public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}	
	//getaccount by id
	@GetMapping("/{id}")
	public ResponseEntity<Accountdto> getAccountById(@PathVariable Long id){
		Accountdto accountdto=accountService.getAccountById(id);
		return ResponseEntity.ok(accountdto);
	}
	//deposit restapi
	@PutMapping("/{id}/deposit")
	public ResponseEntity<Accountdto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request){
		Double amount=request.get("amount");
		Accountdto accountDto=accountService.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	//withdraw amount
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<Accountdto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request){
		Double amount=request.get("amount");
		Accountdto accountDto=accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
}
