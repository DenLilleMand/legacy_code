package org.denlillemand.action;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Når denne klasse bliver kaldt er det første den tjekker på er om username og password felterne er blevet populeret,
 * hvis det er sket, så kalder den vores validate() metode som selv omdiregere folk tilbage til vores signup/login side.
 * hvis der ikke er nogle problemer i validate() så bliver execute() kaldt.
 * @author denlillemand
 *
 */
public class LoginAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public String getTutorial()
	{
		if(getUsername().equals("username") && getPassword().equals(getPassword()))
			return SUCCESS;
		return LOGIN;
		
	}

	
	/**
	 * Vi overrider den her metode fra ActionSupport,
	 * den tjekker om der er nogle fejl, og så redirecter den selv.
	 */
	@Override
	public void validate()
	{
		System.out.println("validate is called");
		if(StringUtils.isEmpty(username))
		{
			System.out.println("username is Empty");
			super.addFieldError("usernamefield", "User name is allready taken");
		}
		if(StringUtils.isEmpty(password))
		{
			System.out.println("password is Empty");
			super.addFieldError("passwordfield","password was not correct");
		}
	}
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	
}
