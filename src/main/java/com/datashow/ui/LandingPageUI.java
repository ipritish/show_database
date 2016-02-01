package main.java.com.datashow.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import main.java.com.datashow.constants.TableHeaders;
import main.java.com.datashow.database.AnimeCRUD;
import main.java.com.datashow.database.ShowCRUD;
import main.java.com.datashow.database.UserSessionDetails;
import main.java.com.datashow.datamodel.AnimeData;
import main.java.com.datashow.datamodel.CustomTableModel;
import main.java.com.datashow.datamodel.ShowData;

public class LandingPageUI {
	
	
	
	CustomTableModel tbModel = new CustomTableModel();
	JTable table = new JTable(tbModel);
	JScrollPane scrollPane = new JScrollPane(table);
	
	private void animeTableDisplay(JPanel panel)
	{
		ShowData.setShowData(ShowCRUD.getAllShows());
		AnimeData.setAnimeData(AnimeCRUD.getAllAnimes());	
		table.removeAll();
		table.setFillsViewportHeight(true);
		panel.remove(scrollPane);
		tbModel.setTableData(AnimeData.getAnimeData(), TableHeaders.getAnimeColumns());
		table.setEnabled(true);
		//use custom table model and custom change listener for the edit
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sizeRenderer(table);
		panel.add(scrollPane);
	}
	
	private void showTableDisplay(JPanel panel) 
	{
		ShowData.setShowData(ShowCRUD.getAllShows());
		AnimeData.setAnimeData(AnimeCRUD.getAllAnimes());		
		table.removeAll();
		table.setFillsViewportHeight(true);
		panel.remove(scrollPane);		
		tbModel.setTableData(ShowData.getShowData(), TableHeaders.getShowColumns());
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(true);
		sizeRenderer(table);
		panel.add(scrollPane);
		
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
	
	public void showGui(final JFrame mainFrame)
	{

		ShowData.setShowData(ShowCRUD.getAllShows());
		AnimeData.setAnimeData(AnimeCRUD.getAllAnimes());
		//list can be used instead menu later test list
		System.out.println(UserSessionDetails.getUserNameLoggedIn());
		mainFrame.getContentPane().removeAll();
		final JPanel landingPanel = new JPanel();
		landingPanel.add(Box.createHorizontalStrut(700));
		
		final JPanel menuPanel = new JPanel();
		JMenuBar menubar = new JMenuBar();
		final JMenu menu = new JMenu("Select");
		JMenuItem itemAnime = new JMenuItem("Anime");
		JMenuItem itemShows = new JMenuItem("Show");
		//itemAnime.add(new JMenuItem("test"));
		landingPanel.setLayout(new BoxLayout(landingPanel, BoxLayout.Y_AXIS));
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));
		//menuPanel.setMaximumSize(menuPanel.getPreferredSize());
		
		itemAnime.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				menu.setText("Anime");
				animeTableDisplay(landingPanel);
				mainFrame.pack();
				
			}
		});
		itemShows.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.setText("Shows");
				showTableDisplay(landingPanel);
				mainFrame.pack();
				
			}

			
		});
		menu.add(itemAnime);
		menu.add(itemShows);
		menubar.add(menu);
		JLabel labelExample = new JLabel("List: ");
		labelExample.setAlignmentY(Component.CENTER_ALIGNMENT);
		menubar.setAlignmentY(Component.CENTER_ALIGNMENT);
		menubar.setMaximumSize(menubar.getPreferredSize());
		
		//Add Button
		JButton addShowEntry = new JButton("Add Show");
		addShowEntry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddShowUI().getAddShowUI(mainFrame);
				
			}
		});
		JButton addAnimeEntry = new JButton("Add Anime");
		addAnimeEntry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddAnimeUI().getAddAnimeUI(mainFrame);
				
			}
		});
		JButton addUser = new JButton("Add User");
		addUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddUserUI().getAddUserUI(mainFrame);
				
			}
		});
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserSessionDetails.setUserLoggedIn(false);
				UserSessionDetails.setUserNameLoggedIn("");
				new LoginUI().getLoginPanel(mainFrame);
			}
		});
		addShowEntry.setAlignmentY(Component.CENTER_ALIGNMENT);
		addAnimeEntry.setAlignmentY(Component.CENTER_ALIGNMENT);
		logoutButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		logoutButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		addUser.setAlignmentY(Component.CENTER_ALIGNMENT);
		//add to menu panel
		menuPanel.add(labelExample);
		menuPanel.add(Box.createHorizontalStrut(10));
		menuPanel.add(menubar);
		menuPanel.add(Box.createHorizontalStrut(10));
		menuPanel.add(addShowEntry);
		menuPanel.add(Box.createHorizontalStrut(10));
		menuPanel.add(addAnimeEntry);
		// add user button only if admin
		if (UserSessionDetails.getUserNameLoggedIn().equals("admin"))
		{
			menuPanel.add(Box.createHorizontalStrut(10));
			menuPanel.add(addUser);
			menuPanel.add(Box.createHorizontalStrut(200));
		}
		//logout button
		else
		{
			menuPanel.add(Box.createHorizontalStrut(300));
		}
		menuPanel.add(logoutButton);
		
		landingPanel.add(Box.createVerticalStrut(20));
		landingPanel.add(menuPanel);
		landingPanel.add(Box.createVerticalStrut(20));
		mainFrame.getContentPane().add(landingPanel);
		mainFrame.getContentPane().revalidate();
		mainFrame.pack();
	}

}
