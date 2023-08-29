package com.cg.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.wallet.dao.WalletDao;
import com.cg.wallet.dao.WalletDao2;
import com.cg.wallet.entity.Wallet;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;

@RestController
@RequestMapping("/wallet")
@CrossOrigin(origins="http://localhost:3000/")
public class WalletController {
	
	@Autowired
	public IWalletService walletService;
	
	@PostMapping("/addWallet")
	public String addWallet(@RequestBody WalletDao walletDao)
	{
		 String str= walletService.addWallet(walletDao);
		 return str;
			
	}

	@GetMapping("/checkWalletAmount/{userId}")
	public Wallet checkWalletAmount(@PathVariable("userId") int userId)
	{
		Wallet amount=walletService.checkWalletAmount(userId);
		
		return amount;
		
	}
	
	@GetMapping("/getWalletById/{walletId}")
	public ResponseEntity<Wallet> getByWalletId(@PathVariable("walletId") int walletId)
	{
		
	Wallet wallet=	walletService.getByWalletId(walletId);
	ResponseEntity<Wallet> responseEntity=new ResponseEntity<>(wallet,HttpStatus.OK);
		return  responseEntity;
		
	}
	
@PutMapping("/updateAmount")
	public ResponseEntity<String> updateWalletAmount(@RequestBody WalletDao2 wallet)
	{
		String str=walletService.updateWalletAmount(wallet);
		ResponseEntity<String> responseEntity=new ResponseEntity<>(str,HttpStatus.OK);
		return  responseEntity;
	}
	

	
	
}
