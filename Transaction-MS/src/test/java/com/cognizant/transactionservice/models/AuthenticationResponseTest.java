package com.cognizant.transactionservice.models;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AuthenticationResponseTest {
	

AuthenticationResponse response = new AuthenticationResponse();
	
	@Test
	void setUserIdTest() 
	{
		response.setUserid("DemoCustomer");
		assertEquals("DemoCustomer", response.getUserid());
	}

	@Test
	void getUserIdTest() 
	{
		response.setUserid("DemoCustomer");
		assertTrue(response.getUserid() == "DemoCustomer");
	}

	@Test
	void setNameTest() 
	{
		response.setName("Ajay");
		assertEquals("Ajay", response.getName());
	}

	@Test
	void getNameTest() 
	{
		response.setName("Samuel");
		assertTrue(response.getName() == "Samuel");
	}

	@Test
	void setisValidTest() 
	{
		response.setValid(true);
		assertEquals(true, response.isValid());
	}
	
	
	AuthenticationResponse response1 = new AuthenticationResponse();
	
	@Test
	void toSringTest() 
	{
		assertEquals(response1.toString(), response.toString());
	}
	
	@Test
	public void getterPassTest() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("password");
		field.setAccessible(true);
		field.set(pojo, "password");
		// when
		String result = pojo.getPassword();
		// then
		assertEquals("password", result, "password");
	}
	
	
	@Test
	public void setterIdTest() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		// when
		pojo.setUserid("abcd");
		// then
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("userid");
		field.setAccessible(true);
		assertEquals("abcd", field.get(pojo), "emp");
	}
	
	@Test
	public void getterId() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("userid");
		field.setAccessible(true);
		field.set(pojo, "values");
		// when
		String result = pojo.getUserid();
		// then
		assertEquals("values", result, "magic_values");
	}
	
	/* Negative Test Cases*/
	
	@Test
	public void getterPassTestNeg() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("password");
		field.setAccessible(true);
		field.set(pojo, "magic_value");
		// when
		String result = pojo.getPassword();
		// then
		assertNotEquals("field wasn't retrieved properly", result, "magic_values");
	}

	@Test
	public void setterIdTestNeg() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		// when
		pojo.setUserid("abcd");
		// then
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("userid");
		field.setAccessible(true);
		assertNotEquals("Fields didn't match", field.get(pojo), "emp");
	}

	@Test
	public void getterIdNeg() throws NoSuchFieldException, IllegalAccessException {
		// given
		AppUser pojo = new AppUser();
		java.lang.reflect.Field field = pojo.getClass().getDeclaredField("userid");
		field.setAccessible(true);
		field.set(pojo, "values");
		// when
		String result = pojo.getUserid();
		// then
		assertNotEquals("field wasn't retrieved properly", result, "magic_values");
	}

}





