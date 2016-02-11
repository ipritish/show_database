package main.java.com.datashow.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.java.com.datashow.database.AnimeCRUD;
import main.java.com.datashow.database.UserSessionDetails;

public class AddAnimeUI {
	
JPanel addAnimePanel;
	
	public void getAddAnimeUI(final JFrame mainFrame)
	{
		//add ui and make operations
		addAnimePanel = new JPanel();
		addAnimePanel.add(Box.createHorizontalStrut(700));
		BoxLayout animelayout = new BoxLayout(addAnimePanel, BoxLayout.Y_AXIS);
		addAnimePanel.setLayout(animelayout);
		
		//anime name field
		JPanel animeNamePanel = new JPanel();
		animeNamePanel.setLayout(new BoxLayout(animeNamePanel, BoxLayout.X_AXIS));
		JLabel  animeNameLabel = new JLabel("Anime Name: ",JLabel.RIGHT);
		animeNameLabel.setMaximumSize(animeNameLabel.getPreferredSize());
		final JTextField animeName = new JTextField(50);
		animeName.setMaximumSize(animeName.getPreferredSize());
		animeName.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		animeNamePanel.add(animeNameLabel);
		animeNamePanel.add(animeName);
		
		
		//anime rating field
		JPanel animeDetailsPanel = new JPanel();
		animeDetailsPanel.setLayout(new BoxLayout(animeDetailsPanel, BoxLayout.X_AXIS));
		JLabel animeRatingLabel = new JLabel("Rating: ",JLabel.RIGHT);
		animeRatingLabel.setMaximumSize(animeRatingLabel.getPreferredSize());
		final JTextField animeRating = new JTextField(20);
		animeRating.setMaximumSize(animeRating.getPreferredSize());
		animeRating.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		//add season in the same panel
		JLabel animeSeasonLabel = new JLabel("Season: ",JLabel.RIGHT);
		animeSeasonLabel.setMaximumSize(animeSeasonLabel.getPreferredSize());
		final JTextField animeSeason = new JTextField(20);
		animeSeason.setMaximumSize(animeSeason.getPreferredSize());
		animeSeason.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		
		animeDetailsPanel.add(animeRatingLabel);
		animeDetailsPanel.add(animeRating);
		animeDetailsPanel.add(Box.createHorizontalStrut(20));
		animeDetailsPanel.add(animeSeasonLabel);
		animeDetailsPanel.add(animeSeason);
		
		//anime airing details
		JPanel animeAiringDetailsPanel = new JPanel();
		animeAiringDetailsPanel.setLayout(new BoxLayout(animeAiringDetailsPanel, BoxLayout.X_AXIS));
		JLabel isAiringLabel = new JLabel("On Air: ",JLabel.RIGHT);
		final JCheckBox isAiring = new JCheckBox();
		isAiring.setMaximumSize(isAiring.getPreferredSize());
		isAiring.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		//anime air day		
		JLabel animeAirDayLabel = new JLabel("Air Day: ",JLabel.RIGHT);
		animeAirDayLabel.setMaximumSize(animeAirDayLabel.getPreferredSize());
		final JTextField animeAirDay = new JTextField(30);
		animeAirDay.setMaximumSize(animeAirDay.getPreferredSize());
		animeAirDay.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		
		animeAiringDetailsPanel.add(isAiringLabel);
		animeAiringDetailsPanel.add(isAiring);
		animeAiringDetailsPanel.add(Box.createHorizontalStrut(20));
		animeAiringDetailsPanel.add(animeAirDayLabel);
		animeAiringDetailsPanel.add(animeAirDay);
		
		//add button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		JButton addAnimeButton = new JButton("Add Anime");
		addAnimeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = animeName.getText();
				double rating = 0;
				int season = 0;
				try
				{
					rating = Double.parseDouble(animeRating.getText());
				}
				catch(NumberFormatException ne)
				{
					JOptionPane.showMessageDialog(mainFrame,"Rating is not double","Error",JOptionPane.ERROR_MESSAGE);
				}
				try
				{
					season = Integer.parseInt(animeSeason.getText());
				}
				catch(NumberFormatException ne)
				{
					JOptionPane.showMessageDialog(mainFrame,"Season is not an integer","Error",JOptionPane.ERROR_MESSAGE);
				}
				boolean onAir = isAiring.isSelected();
				String airDay = animeAirDay.getText();
				AnimeCRUD.addAnime(name, rating, season, onAir, airDay, UserSessionDetails.getUserNameLoggedIn());
				JOptionPane.showMessageDialog(mainFrame,"anime added","Success",JOptionPane.PLAIN_MESSAGE);
				new LandingPageUI().showGui(mainFrame);
				
			}
		});
		JButton cancelButton = new JButton("Cancel");
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LandingPageUI().showGui(mainFrame);
				
			}
		});
		buttonPanel.add(addAnimeButton);
		buttonPanel.add(Box.createHorizontalStrut(20));
		buttonPanel.add(cancelButton);
		//add all panels
		addAnimePanel.add(Box.createVerticalStrut(20));
		addAnimePanel.add(animeNamePanel);
		addAnimePanel.add(Box.createVerticalStrut(10));
		addAnimePanel.add(animeDetailsPanel);
		addAnimePanel.add(Box.createVerticalStrut(10));
		addAnimePanel.add(animeAiringDetailsPanel);
		addAnimePanel.add(Box.createVerticalStrut(10));
		addAnimePanel.add(buttonPanel);
		addAnimePanel.add(Box.createVerticalStrut(20));
		
		
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().add(addAnimePanel);
		mainFrame.revalidate();
		mainFrame.pack();
		
	}

}
