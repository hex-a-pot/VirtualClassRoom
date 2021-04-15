package com.layers.model;

public class Administrator {
	private String name;
	private long id;
	private short age;
	private short pincode;
	private String address;
	private String city;
	private String state;
	private String email;
	private String userName;
	private String password;
	private String country;

	Administrator()

	{
		super();
	}

	Administrator(long id, String name, short age, short pincode, String address, String city, String state,
			String email, String userName, String password, String country) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.pincode = pincode;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public short getPincode() {
		return pincode;
	}

	public void setPincode(short pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
