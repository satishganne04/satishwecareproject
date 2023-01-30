package com.User.User.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(min = 5, max = 10)
    private String password;

    @NotBlank
    @Size(min = 10, max = 10)
    private String mobileNumber;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private LocalDate dateOfBirth;

    @NotBlank
    private String gender;

    @NotBlank
    @Size(min = 6, max = 6)
    private String pincode;

    @NotBlank
    @Size(min = 6, max = 20)
    private String city;

    @NotBlank
    @Size(min = 6, max = 20)
    private String state;

    @NotBlank
    @Size(min = 6, max = 20)
    private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User(Long id, @NotBlank @Size(min = 3, max = 50) String name,
			@NotBlank @Size(min = 5, max = 10) String password, @NotBlank @Size(min = 10, max = 10) String mobileNumber,
			@NotBlank @Email String email, @NotNull LocalDate dateOfBirth, @NotBlank String gender,
			@NotBlank @Size(min = 6, max = 6) String pincode, @NotBlank @Size(min = 6, max = 20) String city,
			@NotBlank @Size(min = 6, max = 20) String state, @NotBlank @Size(min = 6, max = 20) String country) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

