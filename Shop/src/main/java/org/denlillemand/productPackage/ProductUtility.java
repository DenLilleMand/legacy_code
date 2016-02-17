package org.denlillemand.productPackage;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public final class ProductUtility 
{
	
	public static ArrayList<Product> searchProductByName(ObservableList<Product> productList2, String search)
	{
		ArrayList<Product> productList = new ArrayList<Product>();
		for(Product p : productList2)
		{
			if(p.getName().contains(search))
			{
				productList.add(p);
			}
		}
		return productList;
	}

	public static ArrayList<Product> searchProductByName(ObservableList<Product> productList, String search, double maxPrice) 
	{
		ArrayList<Product> tempProductList = new ArrayList<Product>();
		for(Product p : productList)
		{
			if(p.getName().contains(search) && p.getPrice() <= maxPrice)
			{
				tempProductList.add(p);
			}
		}
		return tempProductList;
	}
}
