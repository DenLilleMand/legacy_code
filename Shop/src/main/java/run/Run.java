package run;

import java.util.ArrayList;

import org.denlillemand.productPackage.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Run 
{

	public static void main(String[] args) 
	{
		ObservableList<Product> productList = FXCollections.observableArrayList();
		productList.add(Product.newInstance());
		
		Product[] products = (Product[]) productList.toArray();
		
	}

}
