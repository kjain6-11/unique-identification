package com.forex.uid.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.forex.uid.entity.Address;
import org.springframework.stereotype.Service;
import com.forex.uid.DTO.AdhaarCardDTO;
import com.forex.uid.entity.AdhaarCard;
import com.forex.uid.exception.AdhaarCardException;
import com.forex.uid.repository.AdhaarCardRepository;

@Service
public class AdhaarCardService {

	@Autowired
	private AdhaarCardRepository adhaarCardRepo;
	
	public void verifyAdhaarCard(Long adhaarNumber) throws AdhaarCardException{
		Optional<AdhaarCard> result = this.adhaarCardRepo.findByAdhaarNumber(adhaarNumber);
		if(result.isEmpty()|| !result.get().getAdhaarNumber().equals(adhaarNumber)) {
			throw new AdhaarCardException("Please Enter a valid Adhaar number");
		}		
	}
	
	public String getLinkedPancard(String adhaarCard, String pancard) throws AdhaarCardException {
		this.verifyAdhaarCard(Long.parseLong(adhaarCard));
		Optional<AdhaarCard> result = this.adhaarCardRepo.findByAdhaarNumber(Long.parseLong(adhaarCard));
		if(result.isEmpty()) {
			throw new AdhaarCardException("Please Check your adhaar card number");
		}
		if(result.get().getPancard() == null) {
			throw new AdhaarCardException("Please make sure your adhaar card and pancard is linked");
		}
		if(pancard.equals(result.get().getPancard().getPancardNumber())) {
			System.out.println(result.get().getPancard().getPancardNumber());
			return "pancard verified";
		}
		else {
			return "Please Check Your Pancard Number";
		}
	}
	
	public String getLinkedAddress(AdhaarCardDTO adhaarCardDto) throws AdhaarCardException{
		this.verifyAdhaarCard(Long.parseLong(adhaarCardDto.getAdhaarCardNumber()));
		Optional<AdhaarCard> result = this.adhaarCardRepo.findByAdhaarNumber(Long.parseLong(adhaarCardDto.getAdhaarCardNumber()));
		Address address = result.get().getAddress();
		String permanentAddress = address.getStreet() + address.getCity() + address.getDistrict() + address.getState();
		return permanentAddress;
	}

	public Boolean getAdhaarCardOwnerName(AdhaarCardDTO adhaarCardDTO) throws AdhaarCardException{
		String adhaarCard = adhaarCardDTO.getAdhaarCardNumber();
		if(adhaarCard == null) {
			throw new AdhaarCardException("You must enter the adhaar card");
		}
		this.verifyAdhaarCard(Long.parseLong(adhaarCardDTO.getAdhaarCardNumber()));
		Optional<AdhaarCard> result = this.adhaarCardRepo.findByAdhaarNumber(Long.parseLong(adhaarCardDTO.getAdhaarCardNumber()));
		System.out.println(result.get().getAdhaarNumber());
		System.out.println(result.get().getName());
		System.out.println(adhaarCardDTO.getName());
		if(!result.get().getName().equals(adhaarCardDTO.getName())) {
			throw new AdhaarCardException("You must entered the name same as Adhaar Card");
		}
		return true;
		
	}
	
	public Boolean verifyAdhaarCardOwnerName(String adhaarCard, String ownerName) throws AdhaarCardException{
		
		if(adhaarCard == null) {
			throw new AdhaarCardException("You must enter the adhaar card");
		}
		this.verifyAdhaarCard(Long.parseLong(adhaarCard));
		
		Optional<AdhaarCard> result = this.adhaarCardRepo.findByAdhaarNumber(Long.parseLong(adhaarCard));
		if(!result.get().getName().equals(ownerName)) {
			throw new AdhaarCardException("You must entered the name same as Adhaar Card");
		}
		return true;
	}
}
