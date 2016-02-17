package mattisprojektObserver;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable implements Observer
{
	private DefaultTableModel model = new DefaultTableModel();
	private final String[] columns = {"name"};
	
	public Table(Observable obs)
	{
		setModel(model);
		model.setColumnIdentifiers(columns);
		obs.addObserver(this);
	}
	
	
	public void updateJTable(ArrayList<Person> personList)
	{
		int row = 0;
		model.setRowCount(50);
		for(Person p: personList)
		{
			model.setValueAt(p.getName(), row, 0);
			row++;
		}
	}

	@Override
	public void update(Observable arg0, Object person) 
	{
		int num = 25;
		model.setValueAt(((Person) person).getName(), num++, 0);
	}


}
