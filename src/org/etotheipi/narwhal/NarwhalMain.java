package org.etotheipi.narwhal;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.etotheipi.narwhal.domain.Board;
import org.etotheipi.narwhal.domain.Creep;
import org.etotheipi.narwhal.domain.creep.Wrath;
import org.etotheipi.narwhal.view.TDWUPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class NarwhalMain {
	public static void main(String[] args) {
		
		try {
			final AudioStream audioStream = new AudioStream(
							NarwhalMain.class.getResourceAsStream(
							"sound/UnicornLoop.wav"));
			final AudioPlayer player = AudioPlayer.player;
			Thread th;
			th = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						player.start(audioStream);
					} catch (Exception e) {
						
					}
				}
			});
			th.start();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		final JFrame splash = new JFrame();
		final JFrame splash1 = new JFrame();
		splash1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		splash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		splash1.setResizable(false);
		splash1.add(new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(Constants.SPLASH_SCREEN1_IMAGE.getImage(), 0, 0, this);
			}
		});

		splash1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				splash.setVisible(true);
				splash.setLocation(splash1.getLocation());
				splash1.setVisible(false);
				splash.pack();
			}
		});
		splash.add(new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(Constants.SPLASH_SCREEN_IMAGE.getImage(), 0, 0, this);
			}
		});
		splash.setPreferredSize(new Dimension(600,450));
		splash.setResizable(false);
		System.out.println("NARWHAL!");
		splash.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {

				final JFrame frame = new JFrame();
				Queue<Creep> queue = new ArrayDeque<Creep>();
				while (queue.size() < 5) {
					queue.add(new Wrath());
				}
				frame.add(new TDWUPanel(new Board(queue)));
				frame.setMinimumSize(new Dimension(900,550));
				frame.setPreferredSize(frame.getMinimumSize());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocation(splash.getLocation());
				splash.setVisible(false);
				frame.pack();
				frame.setVisible(true);

			}
		});
		splash1.setPreferredSize(new Dimension(600, 450));
		splash1.pack();
		splash1.setVisible(true);

	}
}
