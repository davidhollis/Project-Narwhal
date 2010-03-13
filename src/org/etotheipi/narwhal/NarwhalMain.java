package org.etotheipi.narwhal;

import java.awt.Dimension;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JFrame;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Creep;
import org.etotheipi.narwhal.domain.creep.Wrath;
import org.etotheipi.narwhal.view.TDWUPanel;

public class NarwhalMain {
	public static void main(String[] args) {
		Queue<Creep> queue = new ArrayDeque<Creep>();
		while (queue.size() < 5) {
			queue.add(new Wrath());
		}
		System.out.println("NARWHAL!");
		JFrame frame = new JFrame();
		frame.add(new TDWUPanel(new Board(queue)));
		frame.setMinimumSize(new Dimension(800,600));
		frame.setPreferredSize(frame.getMinimumSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setVisible(true);
	}
}
