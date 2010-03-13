package org.etotheipi.narwhal.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.etotheipi.narwhal.Constants;
import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Creep;
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

	public GamePanel(final Board fuckingBoard) {
		this.board = fuckingBoard;
		this.setMinimumSize(new Dimension(600,400));
		this.setMaximumSize(this.getMinimumSize());
		this.setPreferredSize(this.getMinimumSize());
		new Timer(250,new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (fuckingBoard == null) {
					System.out.println("AJKLSADHJKLSAD");
					return;
				}
				fuckingBoard.update();
				repaint();
			}
		}).start();
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
		if (this.board == null) return;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				Tower tow = board.getTowerAt(new Point(i,j));
				if (tow != null) {
					ImageIcon icon = getTowerIcon(tow);
					g.drawImage(icon.getImage(), tow.getLocation().x - Constants.SQUARE_SIZE/2,
							tow.getLocation().y - Constants.SQUARE_SIZE/2, this);
				}
			}
		}
		for (Creep cr : board.getCreepsOnBoard()) {
			ImageIcon icon = Constants.getCreepIcon(cr);
			g.drawImage(icon.getImage(), cr.getLocation().x - Constants.CREEP_SIZE/2,
					cr.getLocation().y - Constants.CREEP_SIZE/2, this);
		}

	}



}
