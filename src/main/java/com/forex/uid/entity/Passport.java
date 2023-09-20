package com.forex.uid.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Passport {
	@Id
	private Integer passportId;
	private String passportNumber;
	private String ownerName;
	private LocalDate dateOfBirth;
	private String placeOfBirth;
	private Character gender;
//	private Character type;
	private LocalDate dateOfIssue;
	private LocalDate expiryDate;
	private String nationality;
	
	public Passport() {
		super();
	}

	public Passport(Integer passportId, String passportNumber, String ownerName, LocalDate dateOfBirth, String placeOfBirth, Character gender,
			Character type, LocalDate dateOfIssue, LocalDate expiryDate, String nationality) {
		super();
		this.passportId = passportId;
		this.passportNumber = passportNumber;
		this.ownerName = ownerName;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.gender = gender;
		
		this.dateOfIssue = dateOfIssue;
		this.expiryDate = expiryDate;
		this.nationality = nationality;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
