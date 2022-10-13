package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Account;

@Repository
public interface IAccountRepository extends JpaRepositoryImplementation<Account,Integer>
{
	//Spring Data JPA --- JpaRepositoryImplementation
	
	//Account Retrieve By AccountNo
	@Query("FROM Account a where a.accountNo = ?1 and a.isActive = true")
	public Account findByAccountNo(String accountNo);

}
