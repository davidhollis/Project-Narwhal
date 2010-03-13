package org.etotheipi.narwhal.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Creep;
import org.etotheipi.narwhal.domain.creep.Pride;

public class TDWUPanel extends JPanel {

	private Board board;
	
	private Timer timer;
	
	JPanel scorePanel;
	JLabel healthLabel;
	JLabel moneyLabel;
	
	public TDWUPanel(final Board board) {
		this.board = board;
		Queue<Creep> queue = new ArrayDeque<Creep>();
		while (queue.size() < 5) {
			queue.add(new Pride());
		}

		this.setMinimumSize(new Dimension(800, 600));
		this.setLayout(new BorderLayout());
		GamePanel gp = new GamePanel(board);
		this.add(gp, BorderLayout.WEST);
		this.add(new SidePanel(board, gp), BorderLayout.EAST);
		scorePanel = new JPanel();
		healthLabel = new JLabel("Health: " + board.getThePlayer().getHealth());
		moneyLabel = new JLabel("Health: " + board.getThePlayer().getMoney());
		scorePanel.setLayout(new GridLayout(1,2));
		scorePanel.add(healthLabel);
		scorePanel.add(moneyLabel);
		this.add(scorePanel, BorderLayout.SOUTH);
		new Timer(50,new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (board == null) {
					return;
				}
				board.update();
				healthLabel.setText("Happiness: " + board.getThePlayer().getHealth());
				moneyLabel.setText("Sparkles: " + board.getThePlayer().getMoney());
				repaint();
			}
		}).start();
		
	}
}
