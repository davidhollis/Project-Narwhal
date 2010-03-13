package org.etotheipi.narwhal.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayDeque;

import javax.swing.JPanel;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Creep;

public class TDWUPanel extends JPanel {
	
	private Board board;
	
	public TDWUPanel() {
		board = new Board(new ArrayDeque<Creep>());
		this.setMinimumSize(new Dimension(800, 600));
		this.setLayout(new BorderLayout());
		this.add(new GamePanel(), BorderLayout.WEST);
		this.add(new SidePanel(), BorderLayout.EAST);
	}
}
