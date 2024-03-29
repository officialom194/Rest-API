package com.om.restCRUD.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.restCRUD.Repository.AccountsRepository;
import com.om.restCRUD.entities.Accounts;

@Service
public class AccountsServices {
	@Autowired
	private AccountsRepository  accRepo;
	
	public List<Accounts> getAllAcc()
	{
		List<Accounts> acclist=accRepo.findAll();
		return acclist;
	}
	public Accounts getAccounts(int accno)
	{
		return accRepo.findByAccno(accno);
	}
	public Accounts openAcc(Accounts obj)
	{
		return accRepo.save(obj);
	}
	public List<Accounts> searchOnAcctype(String acctype)
	{
		List<Accounts> typelist=accRepo.findByAcctype(acctype);
		return typelist;
	}
	public String updBal(int accno,float amount)
	{
		
		Accounts obj=accRepo.findByAccno(accno);
		if(obj!=null)
		{
			obj.setBalance(obj.getBalance()+amount);
		   accRepo.save(obj);
		}
		else
		{
			return "Account not found!";
		}
		
		
		return "success";
	}
	public String closeAcc(int accno)
	{
		Accounts obj=accRepo.findByAccno(accno);
		String status="";
		if(obj!=null)
		{
			accRepo.delete(obj);
			status="success"; 
		}
		else
		{
			status="Account not found!";
		}
		
		return status;
	}
	

}
