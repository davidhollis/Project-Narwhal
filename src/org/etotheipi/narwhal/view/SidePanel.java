package org.etotheipi.narwhal.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.etotheipi.narwhal.Constants;
import org.etotheipi.narwhal.domain.Tower;
import org.etotheipi.narwhal.domain.tower.LoveTower;
import org.etotheipi.narwhal.domain.tower.RainbowTower;
import org.etotheipi.narwhal.domain.tower.SunshineTower;
import org.etotheipi.narwhal.domain.tower.UnicornTower;
import org.etotheipi.narwhal.domain.tower.WishTower;

/**
 * This will be the side bar for building the 
 * new Towers and shows what is currently selected.
 */
public class SidePanel extends JPanel {
	
	//Static Final Variables for File names for Icons
	public static final String[] LIST_OF_ICON_PATHS =
		{Constants.LOVE_TOWER, Constants.RAINBOW_TOWER, Constants.WISH_TOWER, 
		 Constants.UNICORN_TOWER, Constants.SUNSHINE_TOWER};
	
	//Constants
	private Tower currentlySelectedTower;
	private String towerName;
	
	private JPanel topPanel;
	private JPanel botPanel;
	
	public JPanel getTopPanel() {
		return topPanel;
	}


	public void setTopPanel(JPanel topPanel) {
		this.topPanel = topPanel;
	}


	public JPanel getBotPanel() {
		return botPanel;
	}


	public void setBotPanel(JPanel botPanel) {
		this.botPanel = botPanel;
	}

	
	/**
	 * Constructor.  Sets up the top and bottom panels 
	 * assuming no tower is selected.
	 */
	public SidePanel() {
		this.setMinimumSize(new Dimension(100, 400));
		this.setPreferredSize(this.getMinimumSize());
		this.setLayout(new GridLayout(2,1));
		topPanel = setUpTopPanel();
		botPanel = setUpBottomPanel();
		this.add(topPanel);
		this.add(botPanel);
	}


	/**
	 * This will set up the top panel.  This will show
	 * the build buttons, that only show the tower 
	 * icons.  
	 * 
	 * TODO:  Need to set up build methods for button actions
	 * @return JPanel for top of side panel.
	 */
	private JPanel setUpTopPanel() {
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		top.setMinimumSize(new Dimension(100,200));
		top.setPreferredSize(top.getMinimumSize());
		for (String filepath : LIST_OF_ICON_PATHS) {
			ImageIcon icon = new ImageIcon(filepath);
			JButton button = new JButton();
			button.setIcon(icon);
			//TODO Set up the actions once the board Panel is made.
			top.add(button);
		}
		return top;
	}
	
	/**
	 * This sets up the bottom panel.  This shows the
	 * icon of the currently selected tower, and all of
	 * its information.  It also has the buttons for 
	 * upgrading and selling.
	 * 
	 * TODO:  Update the tower class to handle upgrading
	 * and deleting
	 * @return new JPanel if nothing is selected, info panel if something is selected.
	 */
	private JPanel setUpBottomPanel() {
		JPanel bot = new JPanel();
		bot.setLayout(new GridLayout(8,1));
		JLabel towerIcon = getMyTowerIcon(currentlySelectedTower);
		bot.add(towerIcon);
		bot.add(new JLabel("Name: " + towerName));
		bot.add(levelPanel());
		bot.add(damagePanel());
		bot.add(rofPanel());
		bot.add(rangePanel());
		JButton upgradeButton = new JButton();
		upgradeButton.setText("Upgrade");
		bot.add(upgradeButton);
		JButton sellButton = new JButton();
		sellButton.setText("Sell");
		bot.add(sellButton);
		
		return currentlySelectedTower == null ? new JPanel() : bot;
	}
	
	/**
	 * Builds the level Panel, left being current, right being next level
	 * @return a JPanel.
	 */
	private JPanel levelPanel() {
		JPanel levelPanel = new JPanel();
		levelPanel.setLayout(new GridLayout(1,2));
		levelPanel.add(new JLabel("Current Level: "
				+ currentlySelectedTower.getLevel()));
		levelPanel.add(new JLabel("Next Level: " + 
				currentlySelectedTower.getLevel() < 5 
				? currentlySelectedTower.getLevel() + 1 : "MAXED"));
		return levelPanel;
	}
	
	/**
	 * Builds the damge Panel, left being current, right being next level
	 * @return a JPanel.
	 */
	private JPanel damagePanel() {
		JPanel damagePanel = new JPanel();
		int currentLevel = currentlySelectedTower.getLevel();
		damagePanel.setLayout(new GridLayout(1,2));
		damagePanel.add(new JLabel("Current Damage: "
				+ currentlySelectedTower.getPower()));
		damagePanel.add(new JLabel("Next Level: " + 
				(currentLevel < 5 ? currentlySelectedTower.getPower(currentLevel + 1) 
						: "MAXED")));
		return damagePanel;
	}
	
	/**
	 * Builds the rate of fire Panel, left being current, right being next level
	 * @return a JPanel.
	 */
	private JPanel rofPanel() {
		JPanel rofPanel = new JPanel();
		int currentLevel = currentlySelectedTower.getLevel();
		rofPanel.setLayout(new GridLayout(1,2));
		rofPanel.add(new JLabel("Current Rate of Fire: "
				+ currentlySelectedTower.getRate()));
		rofPanel.add(new JLabel("Next Level: " + 
				(currentLevel < 5 ? currentlySelectedTower.getRate(currentLevel + 1) 
						: "MAXED")));
		return rofPanel;
	}
	
	/**
	 * Builds the range Panel, left being current, right being next level
	 * @return a JPanel.
	 */
	private JPanel rangePanel() {
		JPanel rangePanel = new JPanel();
		int currentLevel = currentlySelectedTower.getLevel();
		rangePanel.setLayout(new GridLayout(1,2));
		rangePanel.add(new JLabel("Current Damage: "
				+ currentlySelectedTower.getRange()));
		rangePanel.add(new JLabel("Next Level: " + 
				(currentLevel < 5 ? currentlySelectedTower.getRange(currentLevel + 1) 
						: "MAXED")));
		return rangePanel;
	}

	/**
	 * This will get the current tower icon, and return it in a JLabel.
	 * @param tower The tower to look at
	 * @return The JLabel.
	 */
	private JLabel getMyTowerIcon(final Tower tower) {
		//First my switch case for getting icon
		ImageIcon myIcon = null;
		if (tower instanceof RainbowTower) {
			myIcon = Constants.RAINBOW_TOWER_ICON;
			towerName = "Rainbow Tower";
		} else if (tower instanceof LoveTower) {
			myIcon = Constants.LOVE_TOWER_ICON;
			towerName = "Love Tower";
		} else if (tower instanceof WishTower) {
			myIcon = Constants.WISH_TOWER_ICON;
			towerName = "Wish Tower";
		} else if (tower instanceof UnicornTower) {
			myIcon = Constants.UNICORN_TOWER_ICON;
			towerName = "Unicorn Tower";
		} else if (tower instanceof SunshineTower) {
			myIcon = Constants.SUNSHINE_TOWER_ICON;
			towerName = "Sunshine Tower";
		} else {
			System.err.println("AHHH WHAT HAVE WE DONE");
		}
		
		//Now return JPanel containing the icon
		JLabel iconLabel = new JLabel();
		iconLabel.setIcon(myIcon);
		return iconLabel;
	}
	
	public void updatePanel(final Tower selectedTower) {
		currentlySelectedTower = selectedTower;
		setBotPanel(setUpBottomPanel());
	}

	//TEST CODE
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(100,400));
		frame.add(new SidePanel());
		frame.setVisible(true);
		frame.pack();
	}
	
	
}
