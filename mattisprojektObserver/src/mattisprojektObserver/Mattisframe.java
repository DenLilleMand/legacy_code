package mattisprojektObserver;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Mattisframe extends JFrame {

	private JButton addButton;
	private JButton removeButton;

	private Table table;
	private JScrollPane scrollPane;
	private ActionListener buttonListener;

	public Mattisframe() 
	{
		ArrayListWrapper arrayListWrapper = new ArrayListWrapper();
		setLayout(new BorderLayout());
		table = new Table(arrayListWrapper);
		scrollPane = new JScrollPane(table);
		buttonListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent event) {
				int num = 0;
				arrayListWrapper.addPerson(new Person("lol" + num++));
			}

		};

		addButton = new JButton("add person");
		removeButton = new JButton("remove Person");

		addButton.addActionListener(buttonListener);

		add(scrollPane, BorderLayout.CENTER);
		add(addButton, BorderLayout.WEST);
		add(removeButton, BorderLayout.SOUTH);

		table.updateJTable(arrayListWrapper.getList());
		setSize(600, 400);
		pack();
		setVisible(true);
	}

}
