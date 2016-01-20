package main.java.com.datashow.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import main.java.com.datashow.constants.TableHeaders;

public class LandingPageUI {
	
	JTable table = new JTable();
	
	private void animeTableDisplay(JPanel panel)
	{
		table.removeAll();
		panel.remove(table);
		table = new JTable(TableHeaders.placeHoderAnimeData, TableHeaders.animeColumnNames);
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sizeRenderer(table);
		panel.add(table);
	}
	
	private void showTableDisplay(JPanel panel) 
	{
		
		table.removeAll();
		panel.remove(table);		
		table = new JTable(TableHeaders.placeHoderShowData, TableHeaders.animeColumnNames);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
		sizeRenderer(table);
		panel.add(table);
		
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
		//TODO use list instead menu
		mainFrame.getContentPane().removeAll();
		final JPanel landingPanel = new JPanel();
		landingPanel.add(Box.createHorizontalStrut(600));
		
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
		//add to menu panel
		menuPanel.add(labelExample);
		menuPanel.add(Box.createHorizontalStrut(10));
		menuPanel.add(menubar);
		
		landingPanel.add(Box.createVerticalStrut(20));
		landingPanel.add(menuPanel);
		landingPanel.add(Box.createVerticalStrut(20));
		mainFrame.getContentPane().add(landingPanel);
		mainFrame.getContentPane().revalidate();
	}

}
