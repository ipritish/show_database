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

import main.java.com.datashow.database.ShowCRUD;
import main.java.com.datashow.database.UserSessionDetails;

public class AddShowUI {
	
	JPanel addShowPanel;
	
	public void getAddShowUI(final JFrame mainFrame)
	{
		//add ui and make operations
		addShowPanel = new JPanel();
		addShowPanel.add(Box.createHorizontalStrut(700));
		BoxLayout showlayout = new BoxLayout(addShowPanel, BoxLayout.Y_AXIS);
		addShowPanel.setLayout(showlayout);
		
		//show name field
		JPanel showNamePanel = new JPanel();
		showNamePanel.setLayout(new BoxLayout(showNamePanel, BoxLayout.X_AXIS));
		JLabel  showNameLabel = new JLabel("Show Name: ",JLabel.RIGHT);
		showNameLabel.setMaximumSize(showNameLabel.getPreferredSize());
		final JTextField showName = new JTextField(50);
		showName.setMaximumSize(showName.getPreferredSize());
		showName.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		showNamePanel.add(showNameLabel);
		showNamePanel.add(showName);
		
		
		//show rating field
		JPanel showDetailsPanel = new JPanel();
		showDetailsPanel.setLayout(new BoxLayout(showDetailsPanel, BoxLayout.X_AXIS));
		JLabel showRatingLabel = new JLabel("Rating: ",JLabel.RIGHT);
		showRatingLabel.setMaximumSize(showRatingLabel.getPreferredSize());
		final JTextField showRating = new JTextField(20);
		showRating.setMaximumSize(showRating.getPreferredSize());
		showRating.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		//add season in the same panel
		JLabel showSeasonLabel = new JLabel("Season: ",JLabel.RIGHT);
		showSeasonLabel.setMaximumSize(showSeasonLabel.getPreferredSize());
		final JTextField showSeason = new JTextField(20);
		showSeason.setMaximumSize(showSeason.getPreferredSize());
		showSeason.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		
		showDetailsPanel.add(showRatingLabel);
		showDetailsPanel.add(showRating);
		showDetailsPanel.add(Box.createHorizontalStrut(20));
		showDetailsPanel.add(showSeasonLabel);
		showDetailsPanel.add(showSeason);
		
		//show airing details
		JPanel showAiringDetailsPanel = new JPanel();
		showAiringDetailsPanel.setLayout(new BoxLayout(showAiringDetailsPanel, BoxLayout.X_AXIS));
		JLabel isAiringLabel = new JLabel("On Air: ",JLabel.RIGHT);
		final JCheckBox isAiring = new JCheckBox();
		isAiring.setMaximumSize(isAiring.getPreferredSize());
		isAiring.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		//show air day		
		JLabel showAirDayLabel = new JLabel("Air Day: ",JLabel.RIGHT);
		showAirDayLabel.setMaximumSize(showAirDayLabel.getPreferredSize());
		final JTextField showAirDay = new JTextField(30);
		showAirDay.setMaximumSize(showAirDay.getPreferredSize());
		showAirDay.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		
		showAiringDetailsPanel.add(isAiringLabel);
		showAiringDetailsPanel.add(isAiring);
		showAiringDetailsPanel.add(Box.createHorizontalStrut(20));
		showAiringDetailsPanel.add(showAirDayLabel);
		showAiringDetailsPanel.add(showAirDay);
		
		//add button Panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		JButton addShowButton = new JButton("Add Show");
		addShowButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = showName.getText();
				double rating = 0.0;
				int season = 0;
				try
				{
					rating = Double.parseDouble(showRating.getText());
				}
				catch(NumberFormatException ne)
				{
					JOptionPane.showMessageDialog(mainFrame,"Rating is not double","Error",JOptionPane.ERROR_MESSAGE);
				}
				try
				{
					season = Integer.parseInt(showSeason.getText());
				}
				catch(NumberFormatException ne)
				{
					JOptionPane.showMessageDialog(mainFrame,"Season is not an integer","Error",JOptionPane.ERROR_MESSAGE);
				}
				boolean onAir = isAiring.isSelected();
				String airDay = showAirDay.getText();
				ShowCRUD.addShow(name, rating, season, onAir, airDay, UserSessionDetails.getUserNameLoggedIn());
				JOptionPane.showMessageDialog(mainFrame,"show added","Success",JOptionPane.PLAIN_MESSAGE);
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
		buttonPanel.add(addShowButton);
		buttonPanel.add(Box.createHorizontalStrut(20));
		buttonPanel.add(cancelButton);
		
		//add all panels
		addShowPanel.add(Box.createVerticalStrut(20));
		addShowPanel.add(showNamePanel);
		addShowPanel.add(Box.createVerticalStrut(10));
		addShowPanel.add(showDetailsPanel);
		addShowPanel.add(Box.createVerticalStrut(10));
		addShowPanel.add(showAiringDetailsPanel);
		addShowPanel.add(Box.createVerticalStrut(10));
		addShowPanel.add(buttonPanel);
		addShowPanel.add(Box.createVerticalStrut(20));
		
		
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().add(addShowPanel);
		mainFrame.revalidate();
		mainFrame.pack();
		
	}
	
}
