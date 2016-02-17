package org.denlillemand.persistence;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.denlillemand.productPackage.Product;
import org.denlillemand.productPackage.ProductController;


public class PersistenceLoader 
{
	private static final String fileName = "products.ser";
	
	public static void save(ArrayList<Product> productList)
	{
		ObjectOutputStream out = null;
		FileOutputStream fileOut = null;
		try 
		{
			File yourFile = getFile(fileName);
			fileOut = new FileOutputStream(yourFile, false);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(productList); 
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				out.close();
				fileOut.close();
	       } catch (IOException e) 
	       {
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<Product> load() 
	{
		ArrayList<Product> productList = null;
	    try
	    {  
	    	File yourFile = getFile(fileName);
		    FileInputStream fileIn = new FileInputStream(yourFile);
		    ObjectInputStream in = new ObjectInputStream(fileIn);
		    productList = (ArrayList<Product>)in.readObject();
		    in.close();
		    fileIn.close();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		return productList;
	}
	
	private static File getFile(String... paths) 
	{
		String path = new File("").getAbsolutePath();
		StringBuilder sb = new StringBuilder(path);
		for (String s : paths) 
		{
			sb.append(File.separator).append(s);
		}
		File file = new File(sb.toString());
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return file;
	}
	
}
