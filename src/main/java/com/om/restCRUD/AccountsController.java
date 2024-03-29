package com.om.restCRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.om.restCRUD.Repository.AccountsRepository;
import com.om.restCRUD.Services.AccountsServices;
import com.om.restCRUD.entities.Accounts;

@RestController
@RequestMapping("/acc")
public class AccountsController {
	
	@Autowired
	private AccountsServices accServ;
	
	@GetMapping("/allacc")
	public List<Accounts> getAllAcc()
	{
		return accServ.getAllAcc();
	}
	@GetMapping("/accno/{accno}")
	public Accounts getAccounts(@PathVariable int accno)
	{
		return accServ.getAccounts(accno);
	}
	@GetMapping("/acctype/{acctype}")
	public List<Accounts> accType(@PathVariable String acctype)
	{
		return accServ.searchOnAcctype(acctype);
	}
	@PostMapping("/newacc")
	public Accounts openAcc(@RequestBody Accounts acc)
	{
		return accServ.openAcc(acc);
	}
	@PutMapping("/upamount")
	public String updateBalance(@RequestParam int accno,@RequestParam float amount)
	{
		String status=accServ.updBal(accno, amount);
		return status;
	}
	@DeleteMapping("/delacc")
	public String delAcc(@RequestParam int  accno)
	{
		return accServ.closeAcc(accno);
	}

}
