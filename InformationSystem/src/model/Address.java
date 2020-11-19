package model;

public class Address {
	// Polja:
	public String street;
	public String number;
	public String populatedPlace;
	public int postalCode;
	
	// Konstruktori:
	public Address() {}
	
	public Address(String street, String number, String populatedPlace, int postalCode) {
		this.street = street;
		this.number = number;
		this.populatedPlace = populatedPlace;
		this.postalCode = postalCode;
	}
	
	// Dobavljačke i postavljačke radnje:
	public String getStreet() {
		return this.street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getPopulatedPlace() {
		return this.populatedPlace;
	}
	
	public void setPopulatedPlace(String populatedPlace) {
		this.populatedPlace = populatedPlace;
	}
	
	public int getPostalCode() {
		return this.postalCode;
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
}
