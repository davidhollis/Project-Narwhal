package org.etotheipi.narwhal;

import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Sets up overly used constants so that we can use them all over the
 * application.  Used for file paths and icons.
 */
public class Constants {

	public static final URL LOVE_TOWER = NarwhalMain.class.getResource("art/HeartTower.png");
	public static final URL RAINBOW_TOWER = NarwhalMain.class.getResource("art/RainbowTower.png");
	public static final URL WISH_TOWER = NarwhalMain.class.getResource("art/StarTower.png");
	public static final URL UNICORN_TOWER = NarwhalMain.class.getResource("art/UnicornTower.png");
	public static final URL SUNSHINE_TOWER = NarwhalMain.class.getResource("art/SunTower.png");
	public static final URL GAME_BACKGROUND = NarwhalMain.class.getResource("art/GameBackground.png");

	public static final ImageIcon LOVE_TOWER_ICON = new ImageIcon(LOVE_TOWER);
	public static final ImageIcon RAINBOW_TOWER_ICON = new ImageIcon(RAINBOW_TOWER);
	public static final ImageIcon WISH_TOWER_ICON = new ImageIcon(WISH_TOWER);
	public static final ImageIcon UNICORN_TOWER_ICON = new ImageIcon(UNICORN_TOWER);
	public static final ImageIcon SUNSHINE_TOWER_ICON = new ImageIcon(SUNSHINE_TOWER);
	public static final ImageIcon GAME_BACKGROUND_IMAGE = new ImageIcon(GAME_BACKGROUND);

	public static final int MAX_TOWER_LEVEL = 5;
}
