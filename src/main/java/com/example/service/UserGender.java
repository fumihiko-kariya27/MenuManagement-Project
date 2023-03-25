package com.example.service;

enum UserGender {
	
	MALE(1),
	FEMALE(2);
	
	private int gender;
	
	private UserGender(int gender)
	{
		this.gender = gender;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(this.gender);
	}
	
	public int getGender()
	{
		return this.gender;
	}

}
