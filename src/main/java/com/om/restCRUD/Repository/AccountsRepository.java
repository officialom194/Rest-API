package com.om.restCRUD.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.om.restCRUD.entities.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts,Integer> {

	
	Accounts findByAccno(int accno);
    List<Accounts> findByAcctype(String acctype);
}
