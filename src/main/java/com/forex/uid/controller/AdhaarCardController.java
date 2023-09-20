package com.forex.uid.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.forex.uid.DTO.AdhaarCardDTO;
import com.forex.uid.exception.AdhaarCardException;
import com.forex.uid.service.AdhaarCardService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdhaarCardController {
	@Autowired
	private AdhaarCardService adhaarCardService;
	
	@GetMapping("adhaar-card/verification/{adhaarNumber}")//123456789
	public ResponseEntity<String> verifyAdhaarCard(@PathVariable("adhaarNumber") String adhaarNumber) throws AdhaarCardException{
		System.out.println("adhaar " + adhaarNumber);
		System.out.println(Long.parseLong(adhaarNumber));
		this.adhaarCardService.verifyAdhaarCard(Long.parseLong(adhaarNumber));
		return ResponseEntity.ok("Adhaar Verified");
	} 
	@GetMapping("adhaar-card/verification/{adhaarNumber}/{ownerName}")
	public ResponseEntity<String> verifyAdhaarCardOwnerName(@PathVariable("adhaarNumber") String adhaarNumber, @PathVariable("ownerName") String ownerName) throws AdhaarCardException{
		System.out.println(ownerName);
		Boolean isVerified = this.adhaarCardService.verifyAdhaarCardOwnerName(adhaarNumber, ownerName);
		return ResponseEntity.ok("User Verified");
	}
	@GetMapping("adhaar-card/linked-pancard/{adhaarCard}/{pancard}")
	public ResponseEntity<String> getLinkedPancard(@PathVariable("adhaarCard") String adhaarCard, @PathVariable("pancard") String pancard) throws AdhaarCardException{
		String panCardNumber = this.adhaarCardService.getLinkedPancard(adhaarCard, pancard);
		return ResponseEntity.ok(panCardNumber);
	}
	
	@GetMapping("adhaar-card/linked-address")
	public ResponseEntity<String> getLinkedAddress(@RequestBody AdhaarCardDTO adhaarCardDTO) throws AdhaarCardException{
		String permanentAddress = this.adhaarCardService.getLinkedAddress(adhaarCardDTO);
		return ResponseEntity.ok(permanentAddress);
	}
	
	@PostMapping("adhaar-card/owner-name")
	public ResponseEntity<Boolean> getAdhaarCardOwnerName(@RequestBody AdhaarCardDTO adhaarCardDTO) throws AdhaarCardException{
		Boolean ownerName = this.adhaarCardService.getAdhaarCardOwnerName(adhaarCardDTO);
		return ResponseEntity.ok(ownerName);
	}
} 

