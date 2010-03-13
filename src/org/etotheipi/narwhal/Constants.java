package org.etotheipi.narwhal;

import java.net.URL;

import javax.swing.ImageIcon;

import org.etotheipi.narwhal.domain.Creep;
import org.etotheipi.narwhal.domain.creep.Lust;
import org.etotheipi.narwhal.domain.creep.Pride;
import org.etotheipi.narwhal.domain.creep.Sloth;
import org.etotheipi.narwhal.domain.creep.Wrath;

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
	public static final URL GAME_BACKGROUND = NarwhalMain.class.getResource("art/FullBackground.png");
	public static final URL SPLASH_SCREEN = NarwhalMain.class.getResource("art/SplashScreenSparkles.png");
	public static final URL SPLASH_SCREEN1 = NarwhalMain.class.getResource("art/SplashScreenPlain.png");

	public static final URL PRIDE = NarwhalMain.class.getResource("art/PrideDemon.png");
	public static final URL WRATH = NarwhalMain.class.getResource("art/WrathDemon.png");
	public static final URL SLOTH = NarwhalMain.class.getResource("art/SlothDemon.png");
	public static final URL LUST = NarwhalMain.class.getResource("art/LustDemon.png");

	public static final ImageIcon LOVE_TOWER_ICON = new ImageIcon(LOVE_TOWER);
	public static final ImageIcon RAINBOW_TOWER_ICON = new ImageIcon(RAINBOW_TOWER);
	public static final ImageIcon WISH_TOWER_ICON = new ImageIcon(WISH_TOWER);
	public static final ImageIcon UNICORN_TOWER_ICON = new ImageIcon(UNICORN_TOWER);
	public static final ImageIcon SUNSHINE_TOWER_ICON = new ImageIcon(SUNSHINE_TOWER);
	public static final ImageIcon GAME_BACKGROUND_IMAGE = new ImageIcon(GAME_BACKGROUND);
	public static final ImageIcon SPLASH_SCREEN_IMAGE = new ImageIcon(SPLASH_SCREEN);
	public static final ImageIcon SPLASH_SCREEN1_IMAGE = new ImageIcon(SPLASH_SCREEN1);
	
	public static final ImageIcon PRIDE_ICON = new ImageIcon(PRIDE);
	public static final ImageIcon WRATH_ICON = new ImageIcon(WRATH);
	public static final ImageIcon SLOTH_ICON = new ImageIcon(SLOTH);
	public static final ImageIcon LUST_ICON = new ImageIcon(LUST);

	public static final int MAX_TOWER_LEVEL = 5;

	public static final int SQUARE_SIZE = 40; // pixels

	public static final int CREEP_SIZE = 20; // pixels

	public static ImageIcon getCreepIcon(Creep creep) {
		ImageIcon myIcon = null;
		if (creep instanceof Wrath) {
			myIcon = Constants.WRATH_ICON;
		} else if (creep instanceof Lust) {
			myIcon = Constants.LUST_ICON;
		} else if (creep instanceof Pride) {
			myIcon = Constants.PRIDE_ICON;
		} else if (creep instanceof Sloth) {
			myIcon = Constants.SLOTH_ICON;
		} else {
			System.err.println("AHHH WHAT HAVE WE DONE");
		}
		return myIcon;

	}
}
