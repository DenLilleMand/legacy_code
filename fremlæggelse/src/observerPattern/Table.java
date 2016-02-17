package observerPattern;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable implements Observer
{
	private static final long serialVersionUID = 1L;

	private final String[] columns= {"name,age, cpr"};
	DefaultTableModel model;
	
	public Table(Observable observable)
	{
		model = new DefaultTableModel();
		observable.addObserver(this);
		model.setColumnIdentifiers(columns);
	}
	
	
	public void updateJTable(ArrayList<Person> personList)
	{
		 model.setRowCount(personList.size());
		 
		 int row = 0;
		 for(int i = 0; i < personList.size(); i++)
		 {
			 model.setValueAt("", row, 0);
			 model.setValueAt("", row, 1);
			 model.setValueAt("",row , 2);
			 row++;
		 }
		 
	}


	@Override
	public void update(Observable Observable, Object inputObject) 
	{
		model.setRowCount(model.getRowCount() +1); 
		model.setValueAt(((Person) inputObject).getName(), getRowCount(), 0);
		model.setValueAt(((Person) inputObject).getAge(), getRowCount(), 1);
		model.setValueAt(((Person) inputObject).getCpr(), getRowCount(), 2);
		
		//evt check på om en person skal tilføjes eller fjernes
		
	}
	
	
	
	
	
}
