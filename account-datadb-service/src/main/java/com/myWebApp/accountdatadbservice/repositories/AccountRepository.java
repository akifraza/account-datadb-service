package com.myWebApp.accountdatadbservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myWebApp.accountdatadbservice.models.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
	
}
