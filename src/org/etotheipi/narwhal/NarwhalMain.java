package org.etotheipi.narwhal;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.etotheipi.narwhal.view.TDWUPanel;

public class NarwhalMain {
	public static void main(String[] args) {
		System.out.println("NARWHAL!");
		JFrame frame = new JFrame();
		frame.add(new TDWUPanel());
		frame.setMinimumSize(new Dimension(800,600));
		frame.setPreferredSize(frame.getMinimumSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setVisible(true);
	}
}
