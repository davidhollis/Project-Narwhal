package org.etotheipi.narwhal.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JPanel;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Creep;
import org.etotheipi.narwhal.domain.creep.*;

public class TDWUPanel extends JPanel {

	private Board board;

	public TDWUPanel() {
		Queue<Creep> queue = new ArrayDeque<Creep>();
		while (queue.size() < 5) {
			queue.add(new Pride());
		}

		this.setMinimumSize(new Dimension(800, 600));
		this.setLayout(new BorderLayout());
		this.add(new GamePanel(new Board(queue)), BorderLayout.WEST);
		this.add(new SidePanel(), BorderLayout.EAST);
	}
}
