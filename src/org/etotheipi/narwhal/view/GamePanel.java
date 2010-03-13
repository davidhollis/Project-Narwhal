package org.etotheipi.narwhal.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.etotheipi.narwhal.Constants;
import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Bullet;
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
	private Point cursor = null;

	public GamePanel(final Board fuckingBoard) {
		this.board = fuckingBoard;
		this.setMinimumSize(new Dimension(600,400));
		this.setMaximumSize(this.getMinimumSize());
		this.setPreferredSize(this.getMinimumSize());
		new Timer(50,new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (fuckingBoard == null) {
					return;
				}
				fuckingBoard.update();
				repaint();
			}
		}).start();
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent me) {
				cursor = fuckingBoard.getSquareFor(me.getPoint());
			}
		});
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
		if (this.cursor != null) {
			Color oldColor = g.getColor();
			g.setColor(Color.RED);
			((Graphics2D)g).draw(this.board.getBoundsOf(this.cursor));
			g.setColor(oldColor);
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				Tower tow = board.getTowerAt(new Point(i,j));
				if (tow != null) {
					ImageIcon icon = getTowerIcon(tow);
					g.drawImage(icon.getImage(), tow.getLocation().x - Constants.SQUARE_SIZE/2,
							tow.getLocation().y - Constants.SQUARE_SIZE/2, this);
					for (Bullet b : tow.getBullets()) {
						g.drawImage(b.getIcon().getImage(), b.getLocation().x, b.getLocation().y, this);
					}
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
