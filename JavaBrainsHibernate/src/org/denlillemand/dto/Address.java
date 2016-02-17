package org.denlillemand.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/** vi kan bare lade denne klasse have ingen columns,
 * navne specificeret med @Column tagget, og så giver hibernate bare de her tables
 * deres normale navne.  */
@Embeddable
public class Address {
	
	@Column(name="street_name")
	private String street;
	@Column(name="address_name")
	private String city;
	@Column(name="state_name")
	private String state;
	@Column(name="pincode_name")
	private String pincode;
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
