package com.datashow.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.datashow.constants.TableHeaders;

public class AppStarter {
	
	private static final Logger logger = Logger.getLogger(AppStarter.class);
	
	JFrame mainFrame = new JFrame("Shows and Anime");
	JTable table = new JTable();
	
	public void animeTableDisplay(JPanel panel)
	{
		panel.remove(table);
		table = new JTable(TableHeaders.placeHoderAnimeData, TableHeaders.animeColumnNames);
		panel.add(table);
	}
	
	private void showTableDisplay(JPanel panel) {
		
		panel.remove(table);
		table = new JTable(TableHeaders.placeHoderShowData, TableHeaders.animeColumnNames);
		panel.add(table);
		
	}
	
	public void showGui()
	{
		//TODO use list instead menu
		final JPanel panel = new JPanel();
		JMenuBar menubar = new JMenuBar();
		final JMenu menu = new JMenu("Select");
		JMenuItem itemAnime = new JMenuItem("Anime");
		JMenuItem itemShows = new JMenuItem("Show");
		//itemAnime.add(new JMenuItem("test"));
		itemAnime.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				menu.setText("Anime");
				animeTableDisplay(panel);
				
			}
		});
		itemShows.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menu.setText("Shows");
				showTableDisplay(panel);
				
			}

			
		});
		menu.add(itemAnime);
		menu.add(itemShows);
		menubar.add(menu);
		JLabel labelExample = new JLabel("Label");
		labelExample.setSize(20, 10);
		
		panel.add(labelExample);
		panel.add(menubar);
		mainFrame.add(panel);
		mainFrame.setVisible(true);
		mainFrame.setLocation(40, 40);
		Dimension dimension = new Dimension(1000, 700);
		mainFrame.setSize(dimension);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		//System.out.println(getLocalCurrentDate());
		AppStarter start = new AppStarter();
		start.showGui();
	}

	private static String getLocalCurrentDate() {

		if (logger.isDebugEnabled()) {
			logger.debug("getLocalCurrentDate() is executed!");
		}

		return "today's date";

	}

}
