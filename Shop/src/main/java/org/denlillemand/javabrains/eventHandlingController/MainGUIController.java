package org.denlillemand.javabrains.eventHandlingController;

import static constants.StringConstants.*;

import java.util.ArrayList;




import org.denlillemand.mediator.Mediator;
import org.denlillemand.productPackage.Product;
import org.denlillemand.productPackage.ProductController;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class MainGUIController 
{
	private static MainGUIController instance;
	private Mediator mediator;

	
	public static MainGUIController getInstance()
	{
		if(instance == null)
		{
			instance = new MainGUIController();
		}
		return instance;
	}
	
	
	@FXML
	private Tab productsTab;
	
	@FXML
	private TableView<Product> productTable;
	
	@FXML
	private Button newProductButton;
	
	@FXML
	private Button searchButton;

	@FXML
	private Button editButton;
	
	@FXML
	private Button deleteButton;
	
	@FXML
	private ScrollPane productTablePane;
	
	@FXML
	private TableColumn<Product,Integer> productIdColumn;
	@FXML
	private TableColumn<Product,String> productNameColumn;
	@FXML
	private TableColumn<Product,Integer> productQuantityColumn;
	@FXML
	private TableColumn<Product,Integer> productPriceColumn;
	
	
	
	@FXML
	private TextField priceField;
	
	@FXML 
	private TextField nameField;
	
	@FXML
	private Label priceLabel;
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private TextField setIdField;
	
	@FXML
	private TextField setNameField;
	
	@FXML
	private TextField setPriceField;
	
	@FXML
	private TextField setQuantityField;
	
	@FXML
	private Label setIdLabel;
	
	@FXML
	private Label setNameLabel;
	
	@FXML
	private Label setQuantityLabel;
	
	@FXML
	private Label setPriceLabel;
	
	@FXML
	private Tab newProductTab;
	
	private ObservableList<Product> data;
	private ProductController productController = ProductController.getInstance();
	
	
	@SuppressWarnings("unchecked")
	@FXML
	private void initialize()
	{
		instance = this;
		mediator = Mediator.getInstance();
		setIdField.setEditable(false);
		
		
		searchButton.setOnAction((event) -> 
		{
			productController.searchProductsByName(nameField.getText());
		});
		
		newProductButton.setOnAction((event) -> 
		{
			Product product = new Product.Builder().productId(Integer.parseInt(setIdField.getText()))
					.name(setNameField.getText()).quantity(Integer.parseInt(setQuantityField.getText())).
					price(Integer.parseInt(setPriceField.getText())).build();
			
			productController.addProduct(product);
			setIdField.setText(ZERO);
			setNameField.setText(ZERO);
			setPriceField.setText(ZERO);
			setQuantityField.setText(ZERO);
			setIdField.setText(ZERO +productController.getNewId());
			 updateProductList(productController.getCopy());
		});
		
		
		@SuppressWarnings("rawtypes")
		EventHandler<KeyEvent> eventHandler = new EventHandler()
		{
			@Override
			public void handle(Event event) 
			{
				if(priceField.getText().length() == 0)
        		{
        			 	updateProductList(productController.searchProductsByName(nameField.getText()));
        		}
        		else 
        		{
        				System.out.println("double: " +Integer.parseInt(priceField.getText()));
        				updateProductList(productController.searchProductsByNameAndPrice(nameField.getText(),Integer.parseInt(priceField.getText())));
        		}
			}	
		};
		priceField.setOnKeyReleased(eventHandler);
		nameField.setOnKeyReleased(eventHandler);
		
		
		newProductTab.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) 
            {
                if (newProductTab.isSelected()) 
                {
                   setIdField.setText("" +productController.getNewId());
                }
            }
        });
		
		 productPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Price"));
		 productIdColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("ProductId"));
		 productQuantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Quantity"));
		 productNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
		 
		 productsTab.setOnSelectionChanged(new EventHandler<Event>() 
		{
            @Override
            public void handle(Event t) 
            {
               updateProductList(productController.getCopy());
            }
        });
		 updateProductList(productController.getCopy());
		
	}
	
	public void updateProductList(ArrayList<Product> inputList) 
	{
		Platform.runLater(new Runnable() 
		{
            @Override public void run() 
            {
            	data = FXCollections.observableArrayList(inputList);
            	productTable.setItems(data);
            }
        });	
	}	
}
