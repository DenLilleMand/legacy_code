package org.denlillemand.productPackage;

import java.io.Serializable;

public final class Product extends Object implements Serializable
{

	private static final long serialVersionUID = 1L;
	private final  int productId;
	private final  String name;
	private final  int price;
	private final  int quantity;
	
	
	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	private Product(Builder builder)
	{
		productId = builder.productId;
		name = builder.name;
		price = builder.price;
		quantity = builder.quantity;
	}
	
	public static Product newInstance()
	{
		return new Product(new Builder());
	}
	
	public static class Builder
	{
		private int productId;
		private String name;
		private int price;
		private int quantity;
		
		public Builder(){}
		
		public Builder productId(int val)
		{productId = val; return this; }
		
		public Builder name(String val)
		{name = val;  return this;}
		
		public Builder price(int val)
		{price = val; return this;}
		
		public Builder quantity(int val)
		{quantity = val; return this;}
		
		public Product build()
		{ return new Product(this);}
		
	}
}
