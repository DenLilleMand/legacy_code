package org.denlillemand.productPackage;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.denlillemand.javabrains.eventHandlingController.MainGUIController;
import org.denlillemand.persistence.PersistenceLoader;

public final class ProductController 
{
	private ObservableList<Product> productList = FXCollections.observableArrayList();
	private static ProductController instance;
	
	private ProductController()
	{
		productList = FXCollections.observableArrayList(PersistenceLoader.load());
	}
	
	public static ProductController getInstance()
	{
		if(instance == null)
		{
			instance = new ProductController();
		}
		return instance;
	}
	
	public ArrayList<Product> getCopy()
	{
		ArrayList<Product> newList = new ArrayList<Product>();
		
		for(Product p : productList)
		{
			newList.add(p);
		}
		return newList;
	}
	
	public ArrayList<Product> searchProductsByName(String search)
	{
		return ProductUtility.searchProductByName(productList, search);
	}
	
	public void addProduct(Product product)
	{
		productList.add(product);
	}
	
	public void removeProduct(Product product)
	{
		productList.remove(product);
	}

	public int getNewId() 
	{
		int id = 1;
		for(Product p : productList)
		{
			if(p.getProductId() >= id)
			{
				id++;
			}
		}
		return id;
	}

	public ArrayList<Product> searchProductsByNameAndPrice(String search,double parseDouble) {
		return ProductUtility.searchProductByName(productList, search,parseDouble);
	}
	
}
