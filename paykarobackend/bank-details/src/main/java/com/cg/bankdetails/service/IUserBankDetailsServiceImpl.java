package com.cg.bankdetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.bankdetails.dao.User;
import com.cg.bankdetails.dao.UserBankDetailsDao;
import com.cg.bankdetails.entity.UserBankDetails;
import com.cg.bankdetails.repository.UserBankDetailsRepository;


@Service
public class IUserBankDetailsServiceImpl implements IUserBankDetailsService {
	
	@Autowired
	private UserBankDetailsRepository userBankDetailsRepository;

	@Autowired
	private RestTemplate restTemplate;
	


	@Override
	public UserBankDetails saveBankDetails(UserBankDetails bankDetails) {
   
		
		  

		 UserBankDetails userBankDetails=userBankDetailsRepository.save(bankDetails);	
		 return userBankDetails;
	}






	@Override
	public List<UserBankDetails> getAllBankDetails() {
		
		return null;
	}






	@Override
	public UserBankDetailsDao  getByAccountNumber(long accountNumber) {
	Optional<UserBankDetails> optional =userBankDetailsRepository.findByAccountNumber(accountNumber);
	if(optional.isEmpty())
	{
		return null;
	}
	
		UserBankDetails userBankDetails=optional.get();
		
		UserBankDetailsDao userBankDetailsDao=new UserBankDetailsDao();
		
		userBankDetailsDao.setAccountHolderName(userBankDetails.getAccountHolderName());
		userBankDetailsDao.setAccountNumber(userBankDetails.getAccountNumber());
		userBankDetailsDao.setContactNumber(userBankDetails.getContactNumber());
		userBankDetailsDao.setUserId(userBankDetails.getUserId());
		
		return userBankDetailsDao ;
	
	
	}

}