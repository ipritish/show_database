package main.java.com.datashow.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import main.java.com.datashow.constants.TableHeaders;
import main.java.com.datashow.persistence.HibernateUtil;
import main.java.com.datashow.persistence.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainUI {
	
	//private static final Logger logger = Logger.getLogger(AppStarter.class);
	
	JFrame mainFrame = new JFrame("Shows and Anime");
	JTable table = new JTable();
	
	public void animeTableDisplay(JPanel panel)
	{
		table.removeAll();
		panel.remove(table);
		table = new JTable(TableHeaders.placeHoderAnimeData, TableHeaders.animeColumnNames);
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sizeRenderer(table);
		panel.add(table,BorderLayout.CENTER);
	}
	
	private void showTableDisplay(JPanel panel) {
		
		table.removeAll();
		panel.remove(table);		
		table = new JTable(TableHeaders.placeHoderShowData, TableHeaders.animeColumnNames);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
		sizeRenderer(table);
		panel.add(table,BorderLayout.CENTER);
		
	}
	
	private int sizeRenderer(JTable table)
	{
		for (int column = 0; column < table.getColumnCount(); column++)
		{
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();
		 
		    for (int row = 0; row < table.getRowCount(); row++)
		    {
		        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
		        Component c = table.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);
		 
		        //  We've exceeded the maximum width, no need to check other rows
		 
		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }
		 
		    tableColumn.setPreferredWidth(preferredWidth);
		}
		
		return 0;
	}
	
	public void showGui()
	{
		//TODO use list instead menu
		final JPanel panel = new JPanel();
		final JPanel menuPanel = new JPanel();
		JMenuBar menubar = new JMenuBar();
		final JMenu menu = new JMenu("Select");
		JMenuItem itemAnime = new JMenuItem("Anime");
		JMenuItem itemShows = new JMenuItem("Show");
		//itemAnime.add(new JMenuItem("test"));
		panel.setLayout(new BorderLayout());
		
		itemAnime.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				menu.setText("Anime");
				animeTableDisplay(panel);
				mainFrame.pack();
				
			}
		});
		itemShows.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.setText("Shows");
				showTableDisplay(panel);
				mainFrame.pack();
				
			}

			
		});
		menu.add(itemAnime);
		menu.add(itemShows);
		menubar.add(menu);
		JLabel labelExample = new JLabel("Label");
		labelExample.setSize(20, 10);
		
		menuPanel.add(labelExample,BorderLayout.EAST);
		menuPanel.add(new JPanel(),BorderLayout.CENTER);
		menuPanel.add(menubar,BorderLayout.WEST);
		panel.add(menuPanel,BorderLayout.NORTH);
		mainFrame.getContentPane().add(new LoginUI().getLoginPanel());
		mainFrame.setVisible(true);
		mainFrame.setLocation(40, 40);
		mainFrame.setSize(500, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//dataBaseOperate();
	}

	private void dataBaseOperate() 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();
		    
		User user = new User();  
		user.setUserName("Pritish");  
		user.setPassword("password");


		//saving objects to session  
		session.save(user);  
		//session.save(user2);  
		session.getTransaction().commit();  
		session.close();  

		
	}


}
