package org.etotheipi.narwhal.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.etotheipi.narwhal.Constants;
import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Tower;
import org.etotheipi.narwhal.domain.tower.LoveTower;
import org.etotheipi.narwhal.domain.tower.RainbowTower;
import org.etotheipi.narwhal.domain.tower.SunshineTower;
import org.etotheipi.narwhal.domain.tower.UnicornTower;
import org.etotheipi.narwhal.domain.tower.WishTower;

public class GamePanel extends JPanel {
	//constants
	private Point offset = new Point(0,0);
	private Board board;
	
	public GamePanel() {
		this.setMinimumSize(new Dimension(600,400));
		this.setMaximumSize(this.getMinimumSize());
		this.setPreferredSize(this.getMinimumSize());
	}
	
	private ImageIcon getTowerIcon(Tower tower) {
		ImageIcon myIcon = null;
		if (tower instanceof RainbowTower) {
			myIcon = Constants.RAINBOW_TOWER_ICON;
		} else if (tower instanceof LoveTower) {
			myIcon = Constants.LOVE_TOWER_ICON;
		} else if (tower instanceof WishTower) {
			myIcon = Constants.WISH_TOWER_ICON;
		} else if (tower instanceof UnicornTower) {
			myIcon = Constants.UNICORN_TOWER_ICON;
		} else if (tower instanceof SunshineTower) {
			myIcon = Constants.SUNSHINE_TOWER_ICON;
		} else {
			System.err.println("AHHH WHAT HAVE WE DONE");
		}
		return myIcon;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Constants.GAME_BACKGROUND_IMAGE.getImage(), 0, 0, this);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new GamePanel());
		frame.setVisible(true);
		frame.setResizable(false);
		frame.pack();
	}
	
	
	
}
